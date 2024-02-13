package edu.bsu.cs.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class WikiArticleInputTest {
    @Test
    public void testArticleNameInput() {
        String testInput = "Ocean";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        WikiArticleInputName input = new WikiArticleInputName();
        String result = input.articleName(new Scanner(System.in));
        Assertions.assertEquals(testInput, result);
    }
}