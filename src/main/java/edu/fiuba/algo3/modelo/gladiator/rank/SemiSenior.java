package edu.fiuba.algo3.modelo.gladiator.rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public class SemiSenior implements Rank {
    //attributes
    private int shift;
    //methods
    public SemiSenior(){
        this.shift = 0;
    }

    @Override
    public Energy energyFromExperience(Energy amount){
        Energy extraEnergy = new Energy(5);
        return (amount.add(extraEnergy));
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
