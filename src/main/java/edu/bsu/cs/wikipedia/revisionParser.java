package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class revisionParser {

    public List<String> parse(InputStream testInputStream) throws IOException {
        List<String> names = JsonPath.read(testInputStream, "$..revisions..user");
        for (int i = 0; i < names.size(); i++) {
            names.set(i, names.get(i));
        }
        return names;

    }
    public JSONArray parseTimestamps(InputStream testInputStream) throws IOException{
        return (JSONArray) JsonPath.read(testInputStream, "$..revisions..timestamp");
    }
    public JSONArray parseRedirects(InputStream testInputStream) throws IOException{
        return (JSONArray) JsonPath.read(testInputStream, "$..redirects..to");
    }







}