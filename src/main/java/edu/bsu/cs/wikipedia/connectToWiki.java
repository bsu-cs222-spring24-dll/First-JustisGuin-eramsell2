package edu.bsu.cs.wikipedia;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;

public class connectToWiki {

    public static URLConnection connectToWikipedia(WikiArticleInputName input) throws IOException {
        String searchTerm = input.articleName(new Scanner(System.in));
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(searchTerm, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=14&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Project1-Justis-Ethan (justis.guin@bsu.edu)");
        connection.connect();
        return connection;
    }
    public static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }


}