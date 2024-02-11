package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public class revisionParserTest {
    @Test
    public void testNameParse() throws IOException {
        revisionParser parser = new revisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String user = parser.parse(testDataStream);
        Assertions.assertEquals("24.143.118.36", user);


    }
    @Test
    public void testTimestamps() throws IOException{
        revisionParser parser = new revisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamps = parser.parseTimestamps(testDataStream);
        Assertions.assertEquals("2024-02-04T18:19:33Z", timestamps);
    }
    @Test
    public void testRedirects()throws IOException{
        revisionParser parser = new revisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String redirects = parser.parseRedirects(testDataStream);
        Assertions.assertEquals("Frank Zappa", redirects);
    }


}
