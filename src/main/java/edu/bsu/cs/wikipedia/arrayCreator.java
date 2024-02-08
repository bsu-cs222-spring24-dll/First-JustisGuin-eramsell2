package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class arrayCreator {
    String jsonString;
    public arrayCreator(String jsonString){
        this.jsonString = jsonString;
    }
    public JSONArray createJSONArray(String jsonPath){
        return JsonPath.read(jsonString, jsonPath);
    }
}
