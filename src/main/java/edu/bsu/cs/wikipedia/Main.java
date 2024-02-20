package edu.bsu.cs.wikipedia;

import java.io.IOException;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Collections;

import static edu.bsu.cs.wikipedia.revisionParser.getJsonData;
//import static edu.bsu.cs.wikipedia.revisionParser.printRawJson;


public class Main {
    public static void main(String[] args) throws IOException {
        URLConnection connection;
        try {
            WikiArticleInputName input = new WikiArticleInputName();
            errorCatcher error = new errorCatcher();
            connection = connectToWiki.connectToWikipedia(input);
            String jsonData = getJsonData(connection);
            error.noWikiArticlePage(jsonData);
            revisionParser parser = new revisionParser();
            parser.printFormattedList(parser.dateUserList(jsonData));
        } catch (UnknownHostException e) {
            System.err.println("NO CONNECTION DETECTED");
        }
    }



}