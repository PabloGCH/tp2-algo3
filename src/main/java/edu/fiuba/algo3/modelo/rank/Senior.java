package edu.fiuba.algo3.modelo.rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Senior extends Rank{
    //attributes
    
    //methods
    @Override
    public Energy energyFromExperience(Energy amount){
        Energy extraEnergy = new Energy(10);
        return (amount + extraEnergy);
    }

    @Override
    public Rank ascent(){
        this.shift ++;
        System.out.println("maximum range reached");
        return this;
    }

}
