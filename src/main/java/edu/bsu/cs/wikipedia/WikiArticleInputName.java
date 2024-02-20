package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonFormatter;
import net.minidev.json.JSONArray;

import java.util.Scanner;

public class WikiArticleInputName {

    public static String articleName(Scanner scanner) {
        System.out.println("Enter a Wiki Article Name:");

        String input = scanner.nextLine();
        if (input.isEmpty()){
            System.err.println("No page entered");
        }
        return input;

    }


}






