package edu.ntudp.polisnichenko.models;

import java.util.ArrayList;
import java.util.List;

public class Department extends BaseEntity {
    private final ArrayList<Group> groups;

    public Department(String name, Head head) {
        super(name, head);
        groups = new ArrayList<>();
    }

    public Department(String name, Head head, List<Group> groups) {
        super(name, head);
        this.groups = new ArrayList<>(groups);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
}
