package edu.ntudp.polisnichenko.controllers.services.repositories;

import edu.ntudp.polisnichenko.models.Student;
import edu.ntudp.polisnichenko.models.Sex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepository {
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static Connection connection;

    public ArrayList<Student> getAllStudents() throws SQLException {
        String sqlQuery = "SELECT * FROM STUDENTS";
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(sqlQuery);

        return readStudents(resultSet);
    }

    public ArrayList<Student> getStudentsByBirthMonth(int month) throws SQLException {
        var sqlQuery = "SELECT * FROM STUDENTS WHERE MONTH(DATE_OF_BIRTH) = ?";

        var statement = connection.prepareStatement(sqlQuery);
        statement.setInt(1, month);
        ResultSet resultSet = statement.executeQuery();

        return readStudents(resultSet);
    }

    private ArrayList<Student> readStudents(ResultSet resultSet) throws SQLException {
        var students = new ArrayList<Student>();

        while (resultSet.next()) {
            students.add(readStudent(resultSet));
        }

        return students;
    }

    private Student readStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("ID"),
                resultSet.getString("FIRST_NAME"),
                resultSet.getString("LAST_NAME"),
                resultSet.getString("PATRONYMIC"),
                Sex.fromInt(resultSet.getInt("SEX")),
                resultSet.getDate("DATE_OF_BIRTH")
        );
    }

    public void setConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
