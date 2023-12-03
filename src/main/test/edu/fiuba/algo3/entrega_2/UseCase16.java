package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase16 {
    private ArrayList<Effect> effects;
    @BeforeEach
    void setUp() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        ObstaclesRewardsParser parser = new ObstaclesRewardsParser();
        effects = parser.loadEffects("src/main/resources/files/effects.json",
                "effects.json");
    }
    @Test
    void EffectsFileReturnsEffectsArray(){
        assertTrue(effects.get(0) instanceof Effect);
        assertTrue(effects.get(1) instanceof Effect);
        assertTrue(effects.get(2) instanceof Effect);
        assertTrue(effects.get(3) instanceof Effect);
        assertTrue(effects.get(4) instanceof Effect);
    }
    @Test
    void firstEffectIsFood(){
        Gladiator gladiator = new Gladiator();

        effects.get(0).affect(gladiator);
        int energyPoints = gladiator.getEnergy();;

        assertEquals(15, energyPoints);
    }
    @Test
    void secondEffectIsUpgrade(){
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        effects.get(1).affect(gladiator);
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(5, energyPoints);
    }
    @Test
    void thirdEffectIsWine(){
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);
        var initialEnergy = gladiator.getEnergy();

        effects.get(2).affect(gladiator);
        int energyPoints = gladiator.getEnergy();

        assertTrue(initialEnergy > energyPoints);
    }
    @Test
    public void fourthEffectIsBeast(){

        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        effects.get(3).affect(gladiator);
        int energyPoints = gladiator.getEnergy();;

        assertEquals(0, energyPoints);
    }
    @Test
    public void fifthEffectIsInjury(){

        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        effects.get(3).affect(gladiator);
        int energyPoints = gladiator.getEnergy();

        assertEquals(0, energyPoints);
    }
}
