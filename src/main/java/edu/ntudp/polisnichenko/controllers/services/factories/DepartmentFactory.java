package edu.ntudp.polisnichenko.controllers.services.factories;

import edu.ntudp.polisnichenko.models.Department;

public class DepartmentFactory {
    public static Department create(String name) {
        return new Department(name, HeadFactory.create());
    }
}
