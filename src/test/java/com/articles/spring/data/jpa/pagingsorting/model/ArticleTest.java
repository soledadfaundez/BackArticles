package com.articles.spring.data.jpa.pagingsorting.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class ArticleTest {

    @Test
    public void testTitleMaxLength() {
        // Arrange
        Article article = new Article();
        String longTitle = "a".repeat(300); // Creating a long title

        // Act
        article.setTitle(longTitle);

        // Assert
        assertEquals(250, article.getTitle().length());
    }

    @Test
    public void testSummaryMaxLength() {
        // Arrange
        Article article = new Article();
        String longSummary = "a".repeat(1500); // Creating a long summary

        // Act
        article.setSummary(longSummary);

        // Assert
        assertEquals(1000, article.getSummary().length());
    }

    @Test
    public void testNewsSiteMaxLength() {
        // Arrange
        Article article = new Article();
        String longNewsSite = "a".repeat(1500); // Creating a long news site

        // Act
        article.setNewsSite(longNewsSite);

        // Assert
        assertEquals(1000, article.getNewsSite().length());
    }
}
