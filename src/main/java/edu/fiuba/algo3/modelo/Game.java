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
    private ArrayList<Square> path;
    private Dice dice;
    private boolean winner;

    static final int unableNoKey = Config.UNABLE_TO_WIN_ON_FINISH_LINE.getValue();
    static final int able = Config.ABLE_TO_WIN.getValue();


    public Game(ArrayList<Gladiator> gladiators, ArrayList<Square> path, Dice dice) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        this.winner = false;
        this.path = path;
        this.gladiators = gladiators;
        this.dice = dice;
    }

    public boolean startGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        while (turns < Config.MAX_TURNS_IN_A_GAME.getValue() && !this.winner) {
            int player = 0;
            while (player < gladiators.size() && !winner) {
                this.winner = gladiatorTurn(player);
            }
            turns++;
        }
        return result(player);
    }

    public boolean result(int player) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        if (this.winner) {
            System.out.println("Felicidades " + gladiators.get(player).getName() + "ganaste la partida");
            return true;
        }

        System.out.println("No hubo ganadores, suerte la proxima vez");
        return false;
    }
    /*public void createMap() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
         map.add(new Initial());
        map.add(new Middle(new Food()));
        map.add(new Middle(new NullEffect()));
        map.add(new Middle(new Bacchanalia()));
        int middleIndex = (int) (map.stream().count() + 1) / 2;
        map.add(new FinishLine(map.get(middleIndex)));
        this.map = new MapFacade().loadMap();
        path = map.getPath();
        }*/

    private void canGladiatorWin(Gladiator aGladiator) {
        switch (aGladiator.candidateToWin()) {
            case 1:
                map.sendGladiatorToMiddle(aGladiator);
                aGladiator.notWorthy();
            case 2:
                this.winner = true;
        }
    }

    private boolean gladiatorTurn(int player) {
        int diceResult = this.dice.throwDice();
        Gladiator currentGladiator = this.gladiators.get(player);
        int gladiatorPosition = currentGladiator.move(path.size(), diceResult);
        Square currentSquare = this.path.get(gladiatorPosition);
        currentSquare.affect(currentGladiator);
        return false;
    }
}