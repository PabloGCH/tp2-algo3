package edu.fiuba.algo3.modelo.Rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Rooki implements Stage{
    //attributes
    private Rank rank;

    //methods

    @Override
    public Energy energyFromExperience(Energy cantidad){

        return cantidad;
    }
    
    @Override
    public void ascent(){
        System.out.println("congratulations you have been promoted to Semi Senior");
        rank.setStage(new SemiSenior());
    }

    @Override
    public void setRank(Rank rank){
        this.rank = rank;
    }
}
