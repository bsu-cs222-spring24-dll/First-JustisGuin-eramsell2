package edu.bsu.cs.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class revisionParserTest {
    @Test
    public void testParse() throws IOException {
        ArrayList<revisionParser> test = new ArrayList<revisionParser>();
        InputStream testInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");

        Assertions.assertEquals(14,test.size());
    }


}
