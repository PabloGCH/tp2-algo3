package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;

import java.util.Scanner;

import java.util.ArrayList;

public class Game {

    private ArrayList<Gladiator> gladiators = new ArrayList<>();
    private ArrayList<Square> map = new ArrayList<>();

    public void startGame() {
        this.addGladiator();
        this.addGladiator();
        Scanner aScanner = new Scanner(System.in);
        System.out.println("Add a new Gladiator? true/false.");
        boolean addGladiator = aScanner.nextBoolean();
        while(gladiators.stream().count() <= 6 && addGladiator == true) {
            this.addGladiator();
            System.out.println("Add a new Gladiator? true/false.");
            addGladiator = aScanner.nextBoolean();
        }
    }

    public void addGladiator() {
        Gladiator aGladiator = new Gladiator();
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

