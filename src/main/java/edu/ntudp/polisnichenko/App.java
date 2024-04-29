package edu.ntudp.polisnichenko;

import edu.ntudp.polisnichenko.controllers.services.factories.UniversityFactory;
import edu.ntudp.polisnichenko.controllers.services.repositories.StudentRepository;
import edu.ntudp.polisnichenko.models.Student;
import edu.ntudp.polisnichenko.views.UniversityView;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        var university = UniversityFactory.createTypicalUniversity();
        UniversityView.printUniversity(university);
        var dbContext = new StudentRepository();
        dbContext.setConnection();

        int month = getInt(1, 12);

        var students = dbContext.getStudentsByBirthMonth(month);
        printStudents(students);

        dbContext.closeConnection();

    }

    private static void printStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            var student = students.get(i);
            System.out.println(i + ". ID = " + student.getId() + " "+ student.getFullName() + " " + student.getDateOfBirth());
        }
    }

    private static int getInt(int lowerInclusiveBound, int upperInclusiveBound) {
        var succeeded = false;
        var parsedValue = 0;

        while (!succeeded) {
            try {
                parsedValue = input.nextInt();

                if ((upperInclusiveBound != -1 && parsedValue > upperInclusiveBound)
                        || (lowerInclusiveBound != -1 && parsedValue < lowerInclusiveBound)) {
                    throw new ParseException("", 0);
                }

                succeeded = true;
            } catch (Exception e) {
                System.out.println("Try another time");
                input.next();
            }
        }

        return parsedValue;
    }
}
