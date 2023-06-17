package application.library.models;

import jakarta.validation.constraints.*;
import jdk.jfr.DataAmount;

public class Book {

    private int id;
    private int humanid;
   // @NotEmpty(message = "Book name should not be empty")
    @Size(min = 2, max = 30, message = "Book name should be >=2 and <=30 characters")
    private String bookName;
   // @NotEmpty(message = "Author should not be empty")
    @Size(min = 2, max = 30, message = "Author should be >=2 and <=30 characters")
    private String author;
   // @NotEmpty(message = "Release date should not be empty")
  //  @Size(min = 4, max = 4, message = "Release date should contain 4 digits")

    @Min(value = 0, message = "Release date >= 0")
    @Max(value = 2023, message = "Release date <= 2023")
    private int releaseDate;

    public Book() {
    }

    public Book(int id, int humanid, String bookName, String autor, int releaseDate) {
        this.id = id;
        this.humanid = humanid;
        this.bookName = bookName;
        this.author = autor;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHumanid() {
        return humanid;
    }

    public void setHumanid(int humanid) {
        this.humanid = humanid;
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
}
