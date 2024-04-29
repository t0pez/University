package edu.ntudp.polisnichenko;

import edu.ntudp.polisnichenko.controllers.services.factories.UniversityFactory;
import edu.ntudp.polisnichenko.views.UniversityView;

import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
    var university = UniversityFactory.createTypicalUniversity();
    UniversityView.printUniversity(university);
}
}
