package edu.bsu.cs.wikipedia;

public class errorCatcher {


    public void noWikiArticlePage(String data){
        if (data.contains("missing")){
            System.err.println("No Relevant Wiki Page Available");
        }
    }
}
