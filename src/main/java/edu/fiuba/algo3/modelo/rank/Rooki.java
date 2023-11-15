package edu.fiuba.algo3.modelo.rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Rooki extends Rank {
    //attributes

    //methods
    public Rooki(){
        shift = 0;
    }

    @Override
    public Energy energyFromExperience(Energy amount){  
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
