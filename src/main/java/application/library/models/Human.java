package application.library.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Human {
    private int id;
    @Size(min = 2, max = 30, message = "Reader name should be >=2 and <=30 characters")
    private String name;
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
