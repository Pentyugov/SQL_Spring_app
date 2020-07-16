package com.pentyugov.app.dao;

import com.pentyugov.app.model.Author;

import java.util.List;

public interface AuthorDao {

    public Author findAuthorById(long ig);
    public List<Author> findAllAuthors();
    public Author findAuthorByName(String name);
    public void saveAuthor(Author author);
}
