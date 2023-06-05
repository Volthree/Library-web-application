package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jdk.jfr.DataAmount;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "humanid")
//    private int humanid;
    @Size(min = 2, max = 30, message = "Book name should be >=2 and <=30 characters")
    @Column(name = "bookName")
    private String bookName;
    @Size(min = 2, max = 30, message = "Author should be >=2 and <=30 characters")
    @Column(name = "author")
    private String author;

    @Min(value = 0, message = "Release date >= 0")
    @Max(value = 2023, message = "Release date <= 2023")
    @Column(name = "releaseDate")
    private int releaseDate;
    @ManyToOne
    @JoinColumn(name = "humanid", referencedColumnName = "id")
    private Human humanKey;

    public Book() {
    }

    public Book(int id, String bookName, String autor, int releaseDate) {
        this.id = id;
        this.bookName = bookName;
        this.author = autor;
        this.releaseDate = releaseDate;
    }

    public Human getHumanKey() {
        return humanKey;
    }

    public void setHumanKey(Human humanKey) {
        this.humanKey = humanKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", humanKey=" + humanKey +
                '}';
    }
}
