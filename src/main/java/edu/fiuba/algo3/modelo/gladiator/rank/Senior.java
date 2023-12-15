package edu.fiuba.algo3.modelo.gladiator.rank;

public class Senior implements Rank{
    private final int ENERGY_PER_RANK = 10;
    @Override
    public int energyFromExperience(int amount){
        System.out.println("receives " + ENERGY_PER_RANK + " energy points per rank");
        return (amount + ENERGY_PER_RANK);
    }
    @Override
    public Rank ascent(){
        System.out.println("maximum range reached");
        return this;
    }
    public String showRank(){
        return "Senior";
    }
}