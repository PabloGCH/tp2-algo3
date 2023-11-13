package edu.fiuba.algo3.modelo.Rank;

import edu.fiuba.algo3.modelo.energy.Energy;

public class Rank {
    //attributes

    //methods
    private Stage stage;

    public Rank(){
        setStage(new Rooki());
    }

    public Energy energyFromExperience(Energy cantidad){

        return cantidad;
    }

    public void ascent(){
        
    }

    void setStage(Stage stage){
        this.stage = stage;
        this.stage.setRank(this);
    }
}
