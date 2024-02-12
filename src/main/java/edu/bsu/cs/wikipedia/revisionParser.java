package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class revisionParser {
    public String parse(InputStream testInputStream) throws IOException {
        JSONArray names = (JSONArray) JsonPath.read(testInputStream, "$..revisions..user");
        System.out.println(names.get(0).toString());

        return names.get(0).toString();

    }
    public String parseTimestamps(InputStream testInputStream) throws IOException{
        JSONArray timestamps = (JSONArray) JsonPath.read(testInputStream, "$..revisions..timestamp");
        System.out.println(timestamps.get(0).toString());
        return timestamps.get(0).toString();

    }
    public String parseRedirects(InputStream testInputStream) throws IOException{
        JSONArray redirects = (JSONArray) JsonPath.read(testInputStream, "$..redirects..to");
        System.out.println(redirects.get(0).toString());
        return redirects.get(0).toString();

    }








}