package edu.bsu.cs.wikipedia;

import java.util.Objects;
import java.util.Scanner;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikiArticleInputName {
    public String articleName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Wiki Article Name:");
        return scanner.nextLine();
    }


    public void articleNameisEmpty(String jsonRevisionData){
        if (Objects.equals(articleName(), "")) {
            System.err.println("This Article is Empty");
            System.exit(0);
        }
    }


    public void checkArticleIsValid(String jsonRevisionData){
        JSONArray articleRevisions = JsonPath.read(jsonRevisionData, "$..revisions");
        if (articleRevisions.isEmpty()) {
            System.err.println("This Article is Empty");
            System.exit(0);
        }



    }







}
