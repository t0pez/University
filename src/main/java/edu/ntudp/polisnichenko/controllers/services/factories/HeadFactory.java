package edu.ntudp.polisnichenko.controllers.services.factories;

import edu.ntudp.polisnichenko.models.Head;
import edu.ntudp.polisnichenko.models.Sex;

public class HeadFactory extends HumanFactory {

    public static Head create() {
        return create(getRandomSex());
    }

    public static Head create(Sex sex) {
        var firstName = getRandomName();
        var lastName = getRandomName();
        var patronymic = getRandomName();

        return new Head(firstName, lastName, patronymic, sex);
    }
}
