package com.pentyugov.app.dao;

import com.pentyugov.app.mappers.AuthorMapper;
import com.pentyugov.app.model.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Author findAuthorById(long id) {
        final String SQL_FIND_AUTHOR_BY_ID =
                "SELECT * FROM author WHERE author_id = ?";
        return jdbcTemplate.queryForObject(SQL_FIND_AUTHOR_BY_ID, new AuthorMapper(), id);
    }

    @Override
    public List<Author> findAllAuthors() {
        final String SQL_FIND_ALL_AUTHORS =
                "SELECT * FROM author";
        return jdbcTemplate.query(SQL_FIND_ALL_AUTHORS, new AuthorMapper());
    }

    @Override
    public Author findAuthorByName(String name) {
        final String SQL_FIND_AUTHOR_BY_NAME =
                "SELECT * FROM author WHERE author_name = ?";
        return jdbcTemplate.queryForObject(SQL_FIND_AUTHOR_BY_NAME, new AuthorMapper(), name);
    }

    @Override
    public void saveAuthor(Author author) {
        final String SQL_INSERT_INTO_AUTHOR =
                "INSERT INTO author (author_name) VALUES (?)";
        jdbcTemplate.update(SQL_INSERT_INTO_AUTHOR, author.getName());
    }


    /*
    public List<Author> findAllWithBooks() {
        Map<Long, Author> map = new HashMap<>();
        final String SQL_FIND_ALL_AUTHORS_WITH_BOOKS =
                "SELECT a.author_name, b.title from Author a LEFT JOIN BOOKS b on a.author_id = b.author_id";
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_AUTHORS_WITH_BOOKS, rs -> {
            Author author;
            while (rs.next()) {
                Long id = rs.getLong("author_id");
                author = map.get(id);
                if (author == null) {
                    author = new Author();
                    author.setId(id);
                    author.setName(rs.getString(2));
                    author.setBooks(new ArrayList<Book>());
                    map.put(id, author);
                }
                Long bookId = rs.getLong(1);
                if (bookId > 0) {
                    Book book = new Book();
                    book.setId(bookId);
                    book.setTitle(rs.getString(2));
                    author.addBook(book);
                }
            }
            return new ArrayList(map.values());
        });
    }*/
}
