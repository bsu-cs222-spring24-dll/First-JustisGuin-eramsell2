package edu.bsu.cs.wikipedia;

import java.util.Scanner;

public class WikiArticleInputName {

    private String selectedArticle;

    public String articleName(Scanner scanner) {
        System.out.println("Enter a Wiki Article Name:");
        this.selectedArticle = scanner.nextLine();
        return this.selectedArticle;
    }

    public String getSelectedArticle() {
        return this.selectedArticle;
    }

}





