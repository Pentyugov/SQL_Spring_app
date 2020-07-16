package com.pentyugov.app.model;


public class Book {

    private long id;

    private String title;

    private long author_id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getAuthorId() {
        return author_id;
    }

    public void setAuthorId(long author_id) {
        this.author_id = author_id;
    }

    public Book() {

    }

    public Book(String title, long author_id) {
        this.title = title;
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorId='" + author_id + '\'' +
                '}';
    }
}
