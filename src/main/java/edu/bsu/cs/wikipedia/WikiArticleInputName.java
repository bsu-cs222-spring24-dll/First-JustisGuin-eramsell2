package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonFormatter;
import net.minidev.json.JSONArray;

import java.util.Scanner;

public class WikiArticleInputName {

private String selectedArticle;
    //Parse structured data using an appropriate and robust technology such as JsonPath: don't rely
//on naive String searches to extract what data you need.
    public String articleName(Scanner scanner) {
        System.out.println("Enter a Wiki Article Name:");
        this.selectedArticle = scanner.nextLine();
        return this.selectedArticle;
    }

    public String getSelectedArticle(String jsonData) {
        JSONArray hasRevisions = JsonPath.read(jsonData, "$..revisions");
        if (hasRevisions.isEmpty()) {
            System.err.println("There is no wikipedia article that matches your search.");
            System.exit(0);
        }
        return this.selectedArticle;


    }
}






