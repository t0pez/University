package edu.ntudp.polisnichenko.controllers.services.factories;

import edu.ntudp.polisnichenko.models.Group;

public class GroupFactory {
    public static Group create(String name, int studentsCount) {
        return new Group(name, HeadFactory.create(), StudentFactory.create(studentsCount));
    }
}
