package edu.ntudp.polisnichenko.models;

public enum Sex {
    Male(1),
    Female(2);

    private final int id;

    Sex(int id) {
        this.id = id;
    }

    public static Sex fromInt(int rawValue) {
        if (rawValue == Male.id) {
            return Male;
        }

        if (rawValue == Female.id) {
            return Female;
        }

        throw new ClassCastException();
    }
}
