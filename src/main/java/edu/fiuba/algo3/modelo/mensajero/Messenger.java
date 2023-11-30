package edu.fiuba.algo3.modelo.mensajero;
import org.apache.logging.log4j.Logger;

public class Messenger {
    private Logger logger;

    public Messenger(Logger newLogger)
    {
        this.logger = newLogger;
    }
    public void info(String message) throws Exception {
        unassignedLogger();
        logger.info(message);
    }
    public void error(String message) throws Exception {
        unassignedLogger();
        logger.error(message);
    }
    public void warn(String message) throws Exception {
        unassignedLogger();
        logger.warn(message);
    }
    private void unassignedLogger() throws Exception {
        if(logger == null){
            throw new Exception("Unassigned logger");
        }
    }
}
