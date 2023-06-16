package com.example.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

// I think it's not just a human, it's a Reader, you even call them this way in the message.
// Or are there different kinds of humans to be added? E.g. Reader, Librarian?
public class Human {
    private int id;
    @Size(min = 2, max = 30, message = "Reader name should be >=2 and <=30 characters")
    private String name;

//    that's not a day, it's a year
//    and there's actually a proper type for it: https://docs.oracle.com/javase/8/docs/api/java/time/Year.html
//    It should be used instead of int
    @Min(value = 1900, message = "Birthday date >= 1900")
    @Max(value = 2022, message = "Birthday date <= 2022")
    private int birthday;

    public Human() {
    }

    public Human(int id, String name, int birthday) {
        this.name = name;
        this.birthday = birthday;
        this.id = id;
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
