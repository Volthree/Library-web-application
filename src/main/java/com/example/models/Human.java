package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "human")
public class Human {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2, max = 30, message = "Reader name should be >=2 and <=30 characters")
    @Column(name = "name")
    private String name;
    @Min(value = 1900, message = "Birthday date >= 1900")
    @Max(value = 2022, message = "Birthday date <= 2022")
    @Column(name = "birthday")
    private int birthday;
    @OneToMany(mappedBy = "humanKey")
    private List<Book> bookListKey;

    public Human() {
    }

    public Human(int id, String name, int birthday) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
    }

    public List<Book> getBookListKey() {
        return bookListKey;
    }

    public void setBookListKey(List<Book> bookListKey) {
        this.bookListKey = bookListKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }
}
