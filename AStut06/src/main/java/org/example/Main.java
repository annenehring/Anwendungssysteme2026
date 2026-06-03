package org.example;
import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws Exception {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("myobject.ser"));
        os.writeObject(new Student(123456, "Jane Doe", "j.doe@campus.tu-berlin.de"));
        os.close();

    }

    record Student(int id, String name, String mail) implements Serializable { }
}