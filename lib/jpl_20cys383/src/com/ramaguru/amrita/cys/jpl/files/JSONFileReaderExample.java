package com.ramaguru.amrita.cys.jpl.files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * A Java example for reading data from a JSON file.
 */
public class JSONFileReaderExample {

    /**
     * Reads data from a JSON file and prints it to the console.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        // Change the file path if required
        try (FileReader reader = new FileReader("C:\\Projects_Java\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\21ucys.json")) {
            // Parse the JSON file

            JSONArray studentsArray = (JSONArray) parser.parse(reader);

            for (Object obj : studentsArray) {

                JSONObject student = (JSONObject) obj;

                // Extract the values
                String rollNo = (String) student.get("Roll No.");
                String name = (String) student.get("Name");
                String githubId = (String) student.get("GitHub User ID");

                // Print the student details
                System.out.println("Roll No.: " + rollNo);
                System.out.println("Name: " + name);
                System.out.println("GitHub User ID: " + githubId);
                System.out.println();
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
