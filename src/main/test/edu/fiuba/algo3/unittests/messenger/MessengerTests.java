package edu.fiuba.algo3.unittests.messenger;

import edu.fiuba.algo3.modelo.Messenger;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class MessengerTests {
    private static Logger logger = mock(Logger.class);
    private Messenger newMessenger = Messenger.getInstance(logger);
    @Test
    public void test01LoggerCallsInfo() throws Exception {
        newMessenger.info("test");
        Mockito.verify(logger).info("test");
    }
    @Test
    public void test02LoggerCallsWarn() throws Exception {
        newMessenger.warn("test");
        Mockito.verify(logger).warn("test");
    }
    @Test
    public void test03LoggerCallsError() throws Exception {
        newMessenger.error("test");
        Mockito.verify(logger).error("test");
    }
}
