package edu.ntudp.polisnichenko.controllers.services.factories;

import edu.ntudp.polisnichenko.models.Faculty;

public class FacultyFactory {
    public static Faculty create(String name) {
        return new Faculty(name, HeadFactory.create());
    }
}
