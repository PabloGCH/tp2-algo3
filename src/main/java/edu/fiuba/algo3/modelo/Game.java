package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.map.Map;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import java.util.ArrayList;

public class Game {
    private final int MAX_TURNS_IN_A_GAME = 30, NEXT_GLADIATOR_TO_PLAY = 0;
    private int turns = 0;
    private ArrayList<Gladiator> gladiators = new ArrayList<>();
    private ArrayList<Square> path;
    private Dice dice;
    private boolean winner;
    private static Game instance;

    private Game(ArrayList<Gladiator> gladiators, ArrayList<Square> path, Dice dice) {
        this.winner = false;
        this.path = path;
        this.gladiators = gladiators;
        this.dice = dice;
    }
    public static Game getInstance(ArrayList<Gladiator> gladiators, ArrayList<Square> path, Dice dice) {
        if (instance == null) {
            instance = new Game(gladiators, path, dice);
        }
        return instance;
    }
    public boolean startGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        while (turns < MAX_TURNS_IN_A_GAME && !this.winner) {
            int player = 0;
            while (player < gladiators.size() && !winner) {
                this.winner = gladiatorTurn(player);
            }
            turns++;
        }
        return result(player);
    }

    public boolean result(int player) {
        if (this.winner) {
            System.out.println("Felicidades " + gladiators.get(player).getName() + "ganaste la partida");
            return true;
        }

        System.out.println("No hubo ganadores, suerte la proxima vez");
        return false;
    }

    private boolean gladiatorTurn(int diceResult) {
        Gladiator currentGladiator = this.gladiators.get(NEXT_GLADIATOR_TO_PLAY);
        
        int gladiatorPosition = currentGladiator.move(path.size(), diceResult);
        Square currentSquare = this.path.get(gladiatorPosition);

        currentSquare.affect(currentGladiator);
        return false;
    }
}