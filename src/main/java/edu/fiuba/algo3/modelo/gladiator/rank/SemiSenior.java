package edu.fiuba.algo3.modelo.gladiator.rank;

public class SemiSenior implements Rank {
    private int shift;
    private final int ENERGY_PER_RANK = 5, TURNS_FOR_NEXT_RANK = 4;
    public SemiSenior(){
        this.shift = 0;
    }
    @Override
    public int energyFromExperience(int amount){
        System.out.println("receives " + ENERGY_PER_RANK + " energy points per rank");
        return (amount + ENERGY_PER_RANK);
    }
    @Override
    public Rank ascent(){
        this.shift ++;
        if (this.shift == TURNS_FOR_NEXT_RANK) {
            System.out.println("congratulations you have been promoted to Senior");
            return (new Senior());
        }
        return this;
    }
    public String showRank(){
        return "Semi Senior";
    }
}