package edu.fiuba.algo3.modelo.gladiator.rank;

public class Senior implements Rank{
    @Override
    public int energyFromExperience(int amount){
        return (amount + 10);
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