package edu.ntudp.polisnichenko.controllers.services.json;

import com.google.gson.Gson;
import edu.ntudp.polisnichenko.models.University;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UniversityJsonSerializer {
    public static void writeToFile(Object object, String filePath) throws IOException {
        var gson = new Gson();
        var json = gson.toJson(object);

        var writer = new FileWriter(filePath);
        writer.write(json);
        writer.close();
    }

    public static University readFromFile(String filePath) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(filePath), University.class);
    }
}
