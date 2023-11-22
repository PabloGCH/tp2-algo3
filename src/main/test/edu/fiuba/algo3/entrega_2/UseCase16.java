package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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
        Gladiator gladiator = new Gladiator();//Should start with 0 energy points
        //Act
        effects.get(0).affect(gladiator);
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();
        //Assert
        assertEquals(15, energyPoints);
    }
    @Test
    void secondEffectIsUpgrade(){
        Gladiator gladiator = new Gladiator();//Should start with 0 energy points
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);
        //Act
        effects.get(1).affect(gladiator);
        gladiator.fightWithBeast();
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();
        //Assert
                assertEquals(5, energyPoints);
    }
    @Test
    void thirdEffectIsWine(){
        Gladiator gladiator = new Gladiator();//Should start with 20 energy points
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);
        var initialEnergy = gladiator.getEnergy();
        //Act
        effects.get(2).affect(gladiator);
        var newEnergy = gladiator.getEnergy();
        int energyPoints = newEnergy.getPoints();
        //Assert
        assertTrue(initialEnergy.getPoints() > newEnergy.getPoints());
    }
    @Test
    public void fourthEffectIsBeast(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);

        //Act
        effects.get(3).affect(gladiator);
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();
        //Assert
        assertEquals(0, energyPoints);
    }
    @Test
    public void fifthEffectIsInjury(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);

        //Act
        effects.get(3).affect(gladiator);
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();
        //Assert
        assertEquals(0, energyPoints);
    }
}
