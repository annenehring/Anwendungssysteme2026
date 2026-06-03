package org.example;

import java.io.*;
import java.lang.reflect.Field;

/*
Java-Standardserialisierung:
ObjectOutputStream
ObjectInputStream

 */
public class Aufgabe2 {
    record Student(int id, String name, String mail) implements Serializable { }

    public static void writeToDisk(Student s) throws FileNotFoundException, IllegalAccessException {

        PrintWriter p = new PrintWriter("student.txt");
        Class<?> c = s.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {

            f.setAccessible(true);

            String name = f.getName();
            Object value = f.get(s);

            p.println(name + "=" + value);
            p.close();

        }
    }

        public static Student readFromDisk(String dateiName) throws IOException {

            int id = 0;
            String name = null;
            String mail = null;

        try(BufferedReader br = new BufferedReader(new FileReader(dateiName))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts[0].equals("id")) {
                    id = Integer.parseInt(parts[1]);
                }
                if (parts[0].equals("name")) {
                    name = parts[1];
                }
                if (parts[0].equals("mail")) {
                    mail = parts[1];
                }

            }


        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
            return new Student(id, name, mail);
        }




    public static void main(String[] args) {
        Student s = new Student(123456, "Jane Doe", "j.doe@campus.tu-berlin.de");
       try {
          writeToDisk(s);
          System.out.println(readFromDisk("student.txt"));
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
}
