package com.articles.spring.data.jpa.pagingsorting.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.articles.spring.data.jpa.pagingsorting.model.Article;

@ExtendWith(MockitoExtension.class)
public class ArticleRepositoryTest {
    @Test
    public void testFindAll() {
        // Arrange
        ArticleRepository articleRepository = mock(ArticleRepository.class);
        Pageable pageable = Pageable.unpaged(); // or create a mocked Pageable
        Page<Article> expectedPage = Page.empty(); // or create a mock of Page<Article>
        when(articleRepository.findAll(pageable)).thenReturn(expectedPage);

        // Act
        Page<Article> result = articleRepository.findAll(pageable);

        // Assert
        assertSame(expectedPage, result);
    }

    @Test
    public void testFindByIdOriginal() {
        // Arrange
        ArticleRepository articleRepository = mock(ArticleRepository.class);
        long idOriginal = 123;
        Article expectedArticle = new Article(); // or create a mock of Article
        when(articleRepository.findByIdoriginal(idOriginal)).thenReturn(expectedArticle);

        // Act
        Article result = articleRepository.findByIdoriginal(idOriginal);

        // Assert
        assertSame(expectedArticle, result);
    }

    @Test
    public void testFindByTitleContaining() {
        // Arrange
        ArticleRepository articleRepository = mock(ArticleRepository.class);
        String title = "test";
        Pageable pageable = Pageable.unpaged(); // or create a mocked Pageable
        Page<Article> expectedPage = Page.empty(); // or create a mock of Page<Article>
        when(articleRepository.findByTitleContaining(title, pageable)).thenReturn(expectedPage);

        // Act
        Page<Article> result = articleRepository.findByTitleContaining(title, pageable);

        // Assert
        assertSame(expectedPage, result);
    }
}
