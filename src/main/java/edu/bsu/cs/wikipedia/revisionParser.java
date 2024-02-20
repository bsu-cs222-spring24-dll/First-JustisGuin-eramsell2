package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Scanner;

public class revisionParser {

    public String parse(String jsonData) throws IOException {
        JSONArray names = (JSONArray) JsonPath.read(jsonData, "$..revisions..user");
        System.out.println(" User Revisions:");
        for (int i = 0; i < 14; i++) {
            System.out.println((i + 1) + ". " + names.get(i).toString());
        }
        return jsonData;
    }

    public String parseTimestamps(String jsonData) throws IOException {
        JSONArray timestamps = (JSONArray) JsonPath.read(jsonData, "$..revisions..timestamp");
        System.out.println("Time: ");
        for (int i = 0; i < 14; i++) {
            System.out.println((i + 1) + ". " + timestamps.get(i).toString());
        }
        return jsonData;
    }

    public String parseRedirects(String jsonData) throws IOException {
        JSONArray redirects = (JSONArray) JsonPath.read(jsonData, "$..redirects");
        if (!redirects.isEmpty()) {
            JSONArray toArray = (JSONArray) JsonPath.read(jsonData, "$..redirects.to");
            String redirectTo = "";
            if (!toArray.isEmpty()) {
                redirectTo = (String) toArray.get(0);
            }
            System.out.println("Redirected to: " + redirectTo);
        } else {
            System.out.println("No redirects.");

        }
        return jsonData;
    }
    public static String getJsonData(URLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        StringBuilder jsonData = new StringBuilder();
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        while (scanner.hasNext()) {
            jsonData.append(scanner.nextLine());
        }
        scanner.close();
        return jsonData.toString();
    }
    public static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }
    

    public static String getJsonData(URLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        StringBuilder jsonData = new StringBuilder();
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        while(scanner.hasNext()){
            jsonData.append(scanner.nextLine());
        }
        scanner.close();
        return jsonData.toString();


    }
    public static String printRawJson(String jsonData){
        System.out.println(jsonData);
        return jsonData;
    }
}




