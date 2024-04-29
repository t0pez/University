package edu.ntudp.polisnichenko.controllers.services.factories;

import edu.ntudp.polisnichenko.models.Sex;

import java.util.Random;
import java.util.UUID;

public abstract class HumanFactory {
    private static final Random random = new Random();

    protected static Sex getRandomSex() {
        return random.nextInt(2) == 0
                ? Sex.Male
                : Sex.Female;
    }

    protected static String getRandomName() {
        return UUID.randomUUID().toString();
    }
}
