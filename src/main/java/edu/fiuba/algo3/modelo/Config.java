package edu.fiuba.algo3.modelo;

public enum Config {
    MAX_TURNS_IN_A_GAME(30),
    ENERGY_LOST_FOR_EACH_CUP_OF_WINE(4),
    ENERGY_GAINED_FOR_EATING(15),
    ENERGY_LOST_IN_FIGHT_WOUT_EQUIPMENT(20),
    ENERGY_LOST_IN_FIGHT_W_HELMET(15),
    ENERGY_LOST_IN_FIGHT_W_ARMOR(10),
    ENERGY_LOST_IN_FIGHT_W_SWORD(2),
    ENERGY_LOST_IN_FIGHT_W_KEY(0),
    UNABLE_TO_WIN(0),
    UNABLE_TO_WIN_ON_FINISH_LINE(1),
    ABLE_TO_WIN(2);


    private final int value;

    Config(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
};
