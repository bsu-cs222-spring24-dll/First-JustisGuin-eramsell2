package edu.bsu.cs.wikipedia;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

import java.util.Scanner;

public class connectToWiki {

    public static void main(String[] args) throws IOException {
        try {
            WikiArticleInputName input = new WikiArticleInputName();
            errorCatcher error = new errorCatcher();
            URLConnection connection = connectToWikipedia(input);
            String jsonData = getJsonData(connection);
            error.noWikiArticlePage(jsonData);
            printRawJson(jsonData);
            revisionParser parser = new revisionParser();
            parser.parse(jsonData);
            parser.parseTimestamps(jsonData);
            parser.parseRedirects(jsonData);
        } catch (UnknownHostException e) {
            System.err.println("NO CONNECTION DETECTED");
        }
    }

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

    private static String getJsonData(URLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        StringBuilder jsonData = new StringBuilder();
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        while (scanner.hasNext()) {
            jsonData.append(scanner.nextLine());
        }
        scanner.close();
        return jsonData.toString();
    }

    private static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }
}