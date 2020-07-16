package com.pentyugov.app.dao;

import com.pentyugov.app.mappers.BookMapper;
import com.pentyugov.app.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class BookDaoImpl implements BookDao{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Book findBookById(long id) {
        final String SQL_SELECT_BOOK_BY_ID =
                "SELECT * FROM books WHERE book_id = ?";
        return jdbcTemplate.queryForObject(SQL_SELECT_BOOK_BY_ID, new BookMapper(), id);
    }

    @Override
    public List<Book> findALlBooks() {
        final String SQL_SELECT_ALL_BOOKS =
                "SELECT * FROM books";
        return jdbcTemplate.query(SQL_SELECT_ALL_BOOKS, new BookMapper());
    }

    @Override
    public List<Book> findBookByAuthorId(long id) {
        final String SQL_FIND_BOOK_BY_AUTHOR_ID =
                "SELECT * FROM books WHERE author_id = ?";
        return jdbcTemplate.query(SQL_FIND_BOOK_BY_AUTHOR_ID, new BookMapper(), id);
    }

    @Override
    public void addBook(Book book) {

    }


}
