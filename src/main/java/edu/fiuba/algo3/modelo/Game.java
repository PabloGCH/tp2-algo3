package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;

import java.util.Scanner;

import java.util.ArrayList;

public class Game {

    private ArrayList<Gladiator> gladiators = new ArrayList<>();
    private ArrayList<Square> map;
    public Game(ArrayList<Gladiator> gladiators, ArrayList<Square> map) {
        this.map = map;
        for (Gladiator aGladiator : gladiators) {
            this.addGladiator(aGladiator);
        }
    }
    public void startGame() {

    }

    public void addGladiator(Gladiator aGladiator) {
        this.gladiators.add(aGladiator);
        this.map.get(0).receiveGladiator(aGladiator);
    }

    public void createMap() {
        map.add(new Initial());
        map.add(new Middle(new Food()));
        map.add(new Middle(new NullEffect()));
        map.add(new Middle(new Bacchanalia()));
        map.add(new FinishLine());
    }

    public void displayMap() {
        for (Square square : map) {
            System.out.println(square.display());
        }
    }
}
