package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.util.ArrayList;

public class revisionParser {
    String JSONString;
    public revisionParser(String JSONString, String s) {

        this.JSONString = JSONString;
    }


        public ArrayList<revisionParser> createRevisionList() {
            JSONArray JSONRevisions = JsonPath.read(this.JSONString, "$..revisions");
            ArrayList<revisionParser> revisionArrayList = new ArrayList<>();
            ArrayList<String> timestamps = createTimeStampList();
            ArrayList<String> usernames = createUserList();


            for (int arrayIndex = 0; arrayIndex < JSONRevisions.size(); arrayIndex++) {
                revisionArrayList.add(new revisionParser(timestamps.get(arrayIndex), usernames.get(arrayIndex)));
            }
            return revisionArrayList;
        }





    public ArrayList<String> createTimeStampList()
    {
        return JsonPath.read(this.JSONString,"$..revisions.timestamp");
    }
    public ArrayList<String> createUserList()
    {
        return JsonPath.read(this.JSONString,"$..revisions.user");
}}