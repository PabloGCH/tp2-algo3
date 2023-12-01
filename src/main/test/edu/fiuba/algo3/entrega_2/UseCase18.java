package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Messenger;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

public class UseCase18 {
    private static Logger logger = mock(Logger.class);
    private Messenger newMessenger = Messenger.getInstance(logger);
    @Test
    public void loggerCallsInfo() throws Exception {
        newMessenger.info("test");
        Mockito.verify(logger).info("test");
    }
    @Test
    public void loggerCallsWarn() throws Exception {
        newMessenger.warn("test");
        Mockito.verify(logger).warn("test");
    }
    @Test
    public void loggerCallsError() throws Exception {
        newMessenger.error("test");
        Mockito.verify(logger).error("test");
    }
}
