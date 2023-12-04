package edu.fiuba.algo3.modelo.gladiator.rank;

public class Rookie implements Rank {
    //attributes
    private int shift;
    //methods
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
        if (this.shift == 8) {
            System.out.println("congratulations you have been promoted to Semi Senior");
            return (new SemiSenior());
        }
        return this;
    }

}