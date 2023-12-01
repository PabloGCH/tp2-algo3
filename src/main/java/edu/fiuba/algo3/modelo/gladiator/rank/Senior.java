package edu.fiuba.algo3.modelo.gladiator.rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Senior implements Rank{
    //attributes
    
    //methods
    @Override
    public Energy energyFromExperience(Energy amount){
        Energy extraEnergy = new Energy(10);
        return (amount.add(extraEnergy));
    }

    @Override
    public Rank ascent(){
        System.out.println("maximum range reached");
        return this;
    }

}
