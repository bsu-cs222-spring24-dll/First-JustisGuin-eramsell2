package edu.bsu.cs.wikipedia;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.util.Scanner;

public class connectToWiki {

    public static void main(String[] args) throws IOException {
        try {
            WikiArticleInputName input = new WikiArticleInputName();
            URLConnection connection = connectToWikipedia(input);
            String jsonData = readJsonAsStringFrom(connection);
            printRawJson(jsonData);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    public static URLConnection connectToWikipedia(WikiArticleInputName input) throws IOException {
        String searchTerm = input.articleName(new Scanner(System.in));
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(searchTerm, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=14&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (justis.guin@bsu.edu)");
        connection.connect();
        return connection;


    }


    private static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }

    private static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }






}