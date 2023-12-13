package edu.fiuba.algo3.modelo.gladiator.rank;

public class SemiSenior implements Rank {
    private int shift;
    public SemiSenior(){
        this.shift = 0;
    }
    @Override
    public int energyFromExperience(int amount){
        return (amount + 5);
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
    public String showRank(){
        return "Semi Senior";
    }
}