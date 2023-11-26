package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.RandomResult.RandomResult;

import java.util.Random;

public class Dice implements RandomResult {
    Random throwResult = new Random();
    int diceFaces;
    public Dice() {
        this.diceFaces = 6;
    }
    public int throwNumber() {
        int result = throwResult.nextInt(diceFaces) + 1;
        return result;
    };
}
