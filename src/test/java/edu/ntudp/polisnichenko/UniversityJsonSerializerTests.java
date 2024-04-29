package edu.ntudp.polisnichenko;

import edu.ntudp.polisnichenko.controllers.services.factories.UniversityFactory;
import edu.ntudp.polisnichenko.controllers.services.json.UniversityJsonSerializer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;

public class UniversityJsonSerializerTests extends TestCase {
    public static final String FILE_PATH = "test-university.json";

    public UniversityJsonSerializerTests(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(UniversityJsonSerializerTests.class);
    }

    public void test() throws IOException {
        var university = UniversityFactory.createTypicalUniversity();

        UniversityJsonSerializer.writeToFile(university, FILE_PATH);
        var newUniversity = UniversityJsonSerializer.readFromFile(FILE_PATH);

        assertEquals(university.getName(), newUniversity.getName());
    }
}
