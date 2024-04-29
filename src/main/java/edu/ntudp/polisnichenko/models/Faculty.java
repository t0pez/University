package edu.ntudp.polisnichenko.models;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends BaseEntity {
    private final ArrayList<Department> departments;

    public Faculty(String name, Head head) {
        super(name, head);
        departments = new ArrayList<>();
    }

    public Faculty(String name, Head head, List<Department> departments) {
        super(name, head);
        this.departments = new ArrayList<>(departments);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
