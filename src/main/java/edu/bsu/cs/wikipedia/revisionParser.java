package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class revisionParser {
    public String parse(InputStream testInputStream) throws IOException {
        JSONArray revision = (JSONArray) JsonPath.read(testInputStream, "$..user");
        return revision.get(0).toString();
    }
}
