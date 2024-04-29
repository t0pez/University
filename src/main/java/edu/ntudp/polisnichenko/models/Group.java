package edu.ntudp.polisnichenko.models;

import java.util.ArrayList;
import java.util.List;

public class Group extends BaseEntity{
    private final ArrayList<Student> students;

    public Group(String name, Head head) {
        super(name, head);
        students = new ArrayList<>();
    }

    public Group(String name, Head head, List<Student> students) {
        super(name, head);
        this.students = new ArrayList<>(students);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }}
