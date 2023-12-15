package edu.fiuba.algo3.modelo.gladiator.rank;

public class Rookie implements Rank {
    private int shift;
    private final int TURNS_FOR_NEXT_RANK = 8;
    public Rookie(){
        shift = 0;
    }
    @Override
    public int energyFromExperience(int amount){
        return amount ;
    }
    @Override
    public Rank ascent(){
        this.shift ++;
        if (this.shift == TURNS_FOR_NEXT_RANK) {
            System.out.println("congratulations you have been promoted to Semi Senior");
            return (new SemiSenior());
        }
        return this;
    }
    public String showRank(){
        return "Rookie";
    }
}