package com.pentyugov.app;

import com.pentyugov.app.config.SpringConfig;
import com.pentyugov.app.dao.AuthorDaoImpl;
import com.pentyugov.app.dao.BookDaoImpl;
import com.pentyugov.app.model.Author;
import com.pentyugov.app.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDaoImpl bookDao = context.getBean("bookDao", BookDaoImpl.class);
        AuthorDaoImpl authorDao = context.getBean("authorDao", AuthorDaoImpl.class);
        System.out.println(bookDao.findBookById(1));

    }
}
