package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.map.Map;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;

import java.util.Scanner;

import java.util.ArrayList;

public class Game {
    private int turns = 0;
    private ArrayList<Gladiator> gladiators = new ArrayList<>();
    private ArrayList<Position> path;
    private Map map;
    private Dice dice = new Dice();

    private Gladiator winner = null;

    static final int unableNoKey = Config.UNABLE_TO_WIN_ON_FINISH_LINE.getValue();
    static final int able = Config.ABLE_TO_WIN.getValue();


    public Game(ArrayList<Gladiator> gladiators, ArrayList<Position> map) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        createMap();
        this.path = map;
        for (Gladiator aGladiator : gladiators) {
            this.addGladiator(aGladiator);
        }
    }
    public boolean startGame(int maxTurns) {
        //while(turns < Config.MAX_TURNS_IN_A_GAME.getValue()) {
        while(turns < maxTurns) {
            for (Gladiator aGladiator : gladiators) {
                aGladiator.turn();
                canGladiatorWin(aGladiator);
                if(winner != null){
                    //TODO implement message for winner
                    break;
                }
            }
            turns ++;
        }
        return true;//TODO Implement and use method
    }

    public void addGladiator(Gladiator aGladiator) {
        this.gladiators.add(aGladiator);
        this.path.get(0).receivePiece(aGladiator);
    }

    public void createMap() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        /* map.add(new Initial());
        map.add(new Middle(new Food()));
        map.add(new Middle(new NullEffect()));
        map.add(new Middle(new Bacchanalia()));
        int middleIndex = (int) (map.stream().count() + 1) / 2;
        map.add(new FinishLine(map.get(middleIndex))); */
        this.map = new MapFacade().loadMap();
        path = map.getPath();
    }
/*
    public void displayMap() {
        for (Square square : path) {
            System.out.println(square.display());
        }
    }*/
    private void canGladiatorWin(Gladiator aGladiator){//Sacar numeros magicos

        switch (aGladiator.candidateToWin()){
            case 1:
                map.sendGladiatorToMiddle(aGladiator);
            case 2:
                winner = aGladiator;
        }

    }
}
