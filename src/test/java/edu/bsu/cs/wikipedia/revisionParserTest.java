package edu.bsu.cs.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class revisionParserTest {
    @Test
    public void testNameParse() throws IOException {
        revisionParser parser = new revisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String user = parser.parse(String.valueOf(testDataStream));
        Assertions.assertEquals("24.143.118.36", user);


    }
    @Test
    public void testTimestamps() throws IOException{
        revisionParser parser = new revisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamps = parser.parseTimestamps(String.valueOf(testDataStream));
        Assertions.assertEquals("2024-02-04T18:19:33Z", timestamps);
    }
    @Test
    public void testRedirects()throws IOException{
        revisionParser parser = new revisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String redirects = parser.parseRedirects(testDataStream.toString());
        Assertions.assertEquals("Frank Zappa", redirects);
    }


}