package edu.fiuba.algo3.modelo.rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public class SemiSenior extends Rank {
    //attributes
    private int shift;
    //methods
    public SemiSenior(){
        shift = 0;
    }

    @Override
    public Energy energyFromExperience(Energy amount){
        Energy extraEnergy = new Energy(5);
        return (amount + extraEnergy);
    }
    
    @Override
    public Rank ascent(){
        this.shift ++;
        if (this.shift == 4) {
            System.out.println("congratulations you have been promoted to Senior");
            return (new Senior());
        }
        return this;
        
    }

   
}