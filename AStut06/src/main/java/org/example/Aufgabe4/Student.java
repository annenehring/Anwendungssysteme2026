package org.example.Aufgabe4;

import java.util.List;

public class Student {
    int id;
    String name;
    List<String> modules;


    @Override
    public String toString(){

        String moduleNames = "";

        for(int i = 0; i< modules.size(); i++){

            moduleNames += "\"" + modules.get(i) + "\"";


            if(i != modules.size()-1){
                moduleNames += ",";
            }
        }

        return """
         {
            "id": %d
            "name": %s
            "modules": %s
         }   
                """.formatted(id, name, moduleNames);


    }
    public static void main(String[] args) {
        Student s = new Student();

       s.id = 123456;
        s.name = "Jane Doe";
        s.modules = List.of(
                "Math",
                "DB",
                "Java"
        );
        System.out.println(s.toString());

    }
}
