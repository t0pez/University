package edu.ntudp.polisnichenko.controllers.services.factories;

import edu.ntudp.polisnichenko.models.Sex;
import edu.ntudp.polisnichenko.models.Student;

import java.util.ArrayList;

public class StudentFactory extends HumanFactory{
    public static ArrayList<Student> create(int count) {
        var result = new ArrayList<Student>(count);

        for (int i = 0; i < count; i++) {
            result.add(create());
        }

        return result;
    }

    public static Student create() {
        return create(getRandomSex());
    }

    public static Student create(Sex sex) {
        var firstName = getRandomName();
        var lastName = getRandomName();
        var patronymic = getRandomName();

        return new Student(firstName, lastName, patronymic, sex);
    }
}
