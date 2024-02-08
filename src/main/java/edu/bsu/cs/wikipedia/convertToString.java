package edu.bsu.cs.wikipedia;

import java.io.IOException;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class convertToString {
    public String jsonStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }
}
