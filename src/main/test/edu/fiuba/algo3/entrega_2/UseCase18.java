package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Messenger;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

public class UseCase18 {
    private static Logger logger = mock(Logger.class);
    @Test
    public void loggerCallsInfo() throws Exception {
        Messenger newMessenger = Messenger.getInstance(logger);
        newMessenger.info("test");
        Mockito.verify(logger).info("test");
        newMessenger.restartMessenger();
    }
    @Test
    public void loggerCallsWarn() throws Exception {
        Messenger newMessenger = Messenger.getInstance(logger);
        newMessenger.warn("test");
        Mockito.verify(logger).warn("test");
        newMessenger.restartMessenger();
    }
    @Test
    public void loggerCallsError() throws Exception {
        Messenger newMessenger = Messenger.getInstance(logger);
        newMessenger.error("test");
        Mockito.verify(logger).error("test");
        newMessenger.restartMessenger();
    }
}
