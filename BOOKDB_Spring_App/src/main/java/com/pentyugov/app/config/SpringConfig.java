package com.pentyugov.app.config;

import com.pentyugov.app.dao.AuthorDaoImpl;
import com.pentyugov.app.dao.BookDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan("com.pentyugov.app")
@PropertySource("classpath:jdbc/jdbc.properties")
public class SpringConfig {

    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverclassname}")
    private String driverClassName;

    @Bean
    DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return namedParameterJdbcTemplate;
    }

    @Bean
    public BookDaoImpl bookDao() {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.setJdbcTemplate(jdbcTemplate());
        bookDao.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate());
        return bookDao;
    }

    @Bean
    public AuthorDaoImpl authorDao() {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.setJdbcTemplate(jdbcTemplate());
        authorDao.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate());
        return authorDao;
    }

}
