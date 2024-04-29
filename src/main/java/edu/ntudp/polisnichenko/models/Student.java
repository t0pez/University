package edu.ntudp.polisnichenko.models;

import java.util.Date;

public class Student extends Human {
    public Student(String firstName, String lastName, String patronymic, Sex sex) {
        super(firstName, lastName, patronymic, sex);
    }

    public Student(int id, String firstName, String lastName, String patronymic, Sex sex, Date dateOfBirth) {
        super(firstName, lastName, patronymic, sex);
        this.id = id;
        this.dateOfBirth = dateOfBirth;
    }

    private int id;
    private Date dateOfBirth;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getId() {
        return id;
    }
}
