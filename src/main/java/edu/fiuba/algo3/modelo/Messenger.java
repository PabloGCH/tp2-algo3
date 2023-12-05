package edu.fiuba.algo3.modelo;
import org.apache.logging.log4j.Logger;

public class Messenger {
    private static Messenger instance;
    private Logger logger;

    private Messenger(Logger newLogger)
    {
        this.logger = newLogger;
    }
    public static Messenger getInstance(Logger newLogger) {
        if (instance == null) {
            instance = new Messenger(newLogger);
        }
        return instance;
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