package com.articles.spring.data.jpa.pagingsorting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.articles.spring.data.jpa.pagingsorting.model.Article;
import com.articles.spring.data.jpa.pagingsorting.service.ArticlesService;

public class ArticleControllerTest {
    @InjectMocks
    private ArticleController articleController;

    @Mock
    private ArticlesService articlesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByPage() {
        // Arrange
        int offset = 0;
        int limit = 3;
        Map<String, Object> expectedResult = new HashMap<>();
        when(articlesService.findByPage(offset, limit)).thenReturn(new ResponseEntity<>(expectedResult, HttpStatus.OK));

        // Act
        ResponseEntity<Map<String, Object>> result = articleController.findByPage(offset, limit);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(expectedResult, result.getBody());
    }

    @Test
    public void testFindByTitlePage() {
        // Arrange
        String title = "test";
        int offset = 0;
        int limit = 3;
        String[] sort = { "id", "desc" };
        Map<String, Object> expectedResult = new HashMap<>();
        when(articlesService.findByTitleContaining(title, offset, limit, sort))
                .thenReturn(new ResponseEntity<>(expectedResult, HttpStatus.OK));

        // Act
        ResponseEntity<Map<String, Object>> result = articleController.findByTitlePage(title, offset, limit, sort);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(expectedResult, result.getBody());
    }

    @Test
    public void testGetArticlesById() {
        // Arrange
        long id = 1L;
        Article article = new Article(); // Create an article object with appropriate fields
        when(articlesService.getArticlesById(id)).thenReturn(new ResponseEntity<>(article, HttpStatus.OK));

        // Act
        ResponseEntity<Article> result = articleController.getArticlesById(id);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(article, result.getBody());
    }

    @Test
    public void testCreateArticles() {
        // Arrange
        Article article = new Article(); // Create an article object with appropriate fields
        when(articlesService.createArticles(article)).thenReturn(new ResponseEntity<>(article, HttpStatus.CREATED));

        // Act
        ResponseEntity<Article> result = articleController.createArticles(article);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(article, result.getBody());
    }

    @Test
    public void testDeleteArticles() {
        // Arrange
        long id = 1L;
        when(articlesService.deleteArticles(id)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        // Act
        ResponseEntity<HttpStatus> result = articleController.deleteArticles(id);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }

}
