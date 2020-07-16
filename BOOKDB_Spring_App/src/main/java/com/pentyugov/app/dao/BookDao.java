package com.pentyugov.app.dao;

import com.pentyugov.app.model.Book;

import java.util.List;

public interface BookDao {
    public Book findBookById(long id);
    public List<Book> findALlBooks();
    public List<Book> findBookByAuthorId(long id);
    public void addBook(Book book);
}

