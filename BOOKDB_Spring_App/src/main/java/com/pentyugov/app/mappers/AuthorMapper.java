package com.pentyugov.app.mappers;

import com.pentyugov.app.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getLong("author_id"));
        author.setName(rs.getString("author_name"));
        return author;
    }
}
