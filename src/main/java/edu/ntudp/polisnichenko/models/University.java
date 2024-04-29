package edu.ntudp.polisnichenko.models;

import java.util.ArrayList;
import java.util.List;

public class University extends BaseEntity{
    private final ArrayList<Faculty> faculties;

    public University(String name, Head head) {
        super(name, head);
        faculties = new ArrayList<>();
    }

    public University(String name, Head head, List<Faculty> faculties) {
        super(name, head);
        this.faculties = new ArrayList<>(faculties);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
}
