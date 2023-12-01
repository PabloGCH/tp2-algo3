package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.RandomResult.RandomResult;

import java.util.Random;

public class Dice{
    Random throwResult = new Random();
    int diceFaces;
    public Dice() {
        this.diceFaces = 6;
    }
    public int throwDice() {
        return (throwResult.nextInt(diceFaces) + 1);
    }
}
