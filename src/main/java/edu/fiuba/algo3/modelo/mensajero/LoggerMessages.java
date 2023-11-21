package edu.fiuba.algo3.modelo.mensajero;

public interface LoggerMessages {
     void info(String message) throws Exception;
     void error(String message) throws Exception;
     void warn(String message) throws Exception;
}
