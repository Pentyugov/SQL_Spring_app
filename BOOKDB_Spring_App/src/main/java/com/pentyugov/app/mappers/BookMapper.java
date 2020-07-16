package com.pentyugov.app.mappers;

import com.pentyugov.app.model.Author;
import com.pentyugov.app.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthorId(rs.getLong("author_id"));

        return book;
    }
}
