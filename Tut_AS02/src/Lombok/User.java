package Lombok;

import lombok.*;
import lombok.extern.java.Log;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

@ToString
@AllArgsConstructor
@Log
public class User {
    private @Getter @Setter String name;


    public void doSomething(String name){
        log.info("Methode von " + name +"aufgerufen");

        try{
            int a = 10/0;
        }catch(ArithmeticException e){
            log.severe("Fehler: "+ e.getMessage());
        }
    }

    public static void main(String[] args) {
        User u = new User("Paul");
        System.out.println(u.toString());
        System.out.println(u.getName());
            u.doSomething("Anna");
    }
}