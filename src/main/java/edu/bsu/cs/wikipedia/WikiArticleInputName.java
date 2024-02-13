package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonFormatter;
import net.minidev.json.JSONArray;

import java.util.Scanner;

public class WikiArticleInputName {

    //Parse structured data using an appropriate and robust technology such as JsonPath: don't rely
//on naive String searches to extract what data you need.
    public String articleName(Scanner scanner) {
        System.out.println("Enter a Wiki Article Name:");
        return scanner.nextLine();
    }


}






