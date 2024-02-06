package edu.bsu.cs.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class revisionParserTest {
    @Test
    public void testParse() throws IOException {
        revisionParser parser = new revisionParser();
        InputStream testInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String user = parser.parse(testInputStream);
        Assertions.assertEquals("24.143.118.36", user);
    }


}
