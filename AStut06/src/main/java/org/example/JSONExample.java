package org.example;
import java.nio.file.Files;
import java.nio.file.Path;

public class JSONExample {

        public static void main(String[] args) throws Exception {

            String json = """
        {
            "id": 123456,
            "name": "Jane Doe"
        }
        """;

            Files.writeString( Path.of("student.json"), json);

            System.out.println("Datei gespeichert!");
        }
}
