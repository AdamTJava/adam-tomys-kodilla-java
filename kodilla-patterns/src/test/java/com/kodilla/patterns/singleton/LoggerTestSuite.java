package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    private static Logger logger;

    @Test
    void testGetLastLog() {
        //Given
        logger = Logger.INSTANCE;
        logger.log("First log");
        //When
        String expected = "First log";
        String actual = logger.getLastLog();
        //Then
        Assertions.assertEquals(expected, actual);
    }

}
