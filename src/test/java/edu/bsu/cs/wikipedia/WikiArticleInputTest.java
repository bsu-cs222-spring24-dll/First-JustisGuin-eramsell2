package edu.bsu.cs.wikipedia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class WikiArticleInputNameTest {
        @Test
        void testCheckArticleIsValidWithEmptyData() {
            WikiArticleInputName wikiArticleInputName = new WikiArticleInputName();
            String jsonRevisionData = "{}";
            assertThrows(RuntimeException.class, () -> wikiArticleInputName.isarticleNameEmpty(jsonRevisionData));
        }
        @Test
        void testCheckArticleIsValidWithValidData() {
            WikiArticleInputName wikiArticleInputName = new WikiArticleInputName();
            String jsonRevisionData = "{\"revisions\": [{\"user\": \"User\", \"timestamp\": \"2023-03-28T15:02:23Z\", \"comment\": \"Initial revision\", \"content\": \"{\\\"article\\\":\\\"Test\\\"}\"}]}";
            assertDoesNotThrow(() -> wikiArticleInputName.checkArticleIsValid(jsonRevisionData));
        }


    }