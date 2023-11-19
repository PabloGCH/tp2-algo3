package edu.fiuba.algo3.modelo.equipment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.fiuba.algo3.modelo.energy.Energy;

public class NullEquipment implements Equipment {
    private static final Logger logger = LogManager.getLogger("vehicles");
    public Equipment upgrade() {
        return new Helmet();
    }

    public Energy receiveAttack(Energy energy){
        logger.info("subtracting energy");
        logger.info("finished subtracting energy");
        return energy.substract(new Energy(20));
    }
}
