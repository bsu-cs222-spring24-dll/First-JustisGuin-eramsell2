package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public class revisionParser {
    public String parse(InputStream testInputStream) throws IOException {
        JSONArray names = (JSONArray) JsonPath.read(testInputStream, "$..revisions..user");

        return names.get(0).toString();

    }
    public String parseTimestamps(InputStream testInputStream) throws IOException{
        JSONArray timestamps = (JSONArray) JsonPath.read(testInputStream, "$..revisions..timestamp");
        return timestamps.get(0).toString();

    }
    public String parseRedirects(InputStream testInputStream) throws IOException{
        JSONArray redirects = (JSONArray) JsonPath.read(testInputStream, "$..redirects..to");
        return redirects.get(0).toString();

    }







}