package edu.fiuba.algo3.unittests.messenger;

import edu.fiuba.algo3.modelo.Messenger;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class MessengerTests {
    private static final Logger logger = mock(Logger.class);
    @Test
    public void test01LoggerCallsInfo() throws Exception {
        Messenger newMessenger = Messenger.getInstance(logger);
        newMessenger.info("test");
        Mockito.verify(logger).info("test");
        newMessenger.restartMessenger();
    }
    @Test
    public void test02LoggerCallsWarn() throws Exception {
        Messenger newMessenger = Messenger.getInstance(logger);
        newMessenger.warn("test");
        Mockito.verify(logger).warn("test");
        newMessenger.restartMessenger();
    }
    @Test
    public void test03LoggerCallsError() throws Exception {
        Messenger newMessenger = Messenger.getInstance(logger);
        newMessenger.error("test");
        Mockito.verify(logger).error("test");
        newMessenger.restartMessenger();
    }

    @Test
    public void test04NullLoggerThrowsExceptions(){
        Messenger newMessenger = Messenger.getInstance(null);
        assertThrows(Exception.class, () -> newMessenger.error("test"));
        newMessenger.restartMessenger();
    }
}
