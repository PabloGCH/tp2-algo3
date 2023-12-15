package edu.fiuba.algo3.modelo;
import org.apache.logging.log4j.Logger;

public class Messenger {
    private static Messenger instance;
    private final Logger logger;
    private Messenger(Logger newLogger)
    {
        this.logger = newLogger;
    }
    public void restartMessenger() {
        instance = null;
    }
    public static Messenger getInstance() {
        return instance;
    }
    public static Messenger getInstance(Logger newLogger) {
        if (instance == null) {
            instance = new Messenger(newLogger);
        }
        return instance;
    }
    public void info(String message) {
        try {
            unassignedLogger();
            logger.info(message);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void error(String message) {
        try {
            unassignedLogger();
            logger.error(message);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void warn(String message) {
        try {
            unassignedLogger();
            logger.warn(message);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private void unassignedLogger() throws Exception {
        if(logger == null){
            throw new Exception("Unassigned logger");
        }
    }
}