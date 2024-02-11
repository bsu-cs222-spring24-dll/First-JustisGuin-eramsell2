package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
public class revisionParser {
    public JSONArray parse(InputStream testInputStream) throws IOException {
        JSONArray names = (JSONArray) JsonPath.read(testInputStream, "$..revisions..user");

        return names;

    }
    public JSONArray parseTimestamps(InputStream testInputStream) throws IOException{
        JSONArray timestamps = (JSONArray) JsonPath.read(testInputStream, "$..revisions..timestamp");
        return timestamps;
    }
    public JSONArray parseRedirects(InputStream testInputStream) throws IOException{
        JSONArray redirects = (JSONArray) JsonPath.read(testInputStream, "$..redirects..to");
        return redirects;
    }





}