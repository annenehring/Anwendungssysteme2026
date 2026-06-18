package org.example;

import org.example.UserOuterClass.Users;
import org.example.UserOuterClass.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
TODO:Benutzen Sie die Intellij Vorlage und erstellen Sie im Ordner src/main/proto eine Datei users.proto, mit der sie die Daten
 aus Aufgabe 11 speichern können. Schreiben Sie dann eine main-Methode, die die User in eine Datei schreibt (z. B. user.bin)
 und eine andere main-Methode, die diese Datei einliest und die User auf der Konsole ausgibt.
 */

public class UserReader {

    public static void main(String[] args) {

        try(FileInputStream in = new FileInputStream("user.bin")){

            Users users = Users.parseFrom(in);
            System.out.println(users.toString());

            for(User u : users.getUsersList()){
                System.out.println("ID des users: " + u.getId() + " Name: " + u.getName());
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}