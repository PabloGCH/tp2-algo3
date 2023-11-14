package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Game;

public class Main {
    public static void main(String[] args) {
        //App.main(args);
        Game game = new Game();
        game.createMap();
        game.startGame();
        game.displayMap();
    }
}
