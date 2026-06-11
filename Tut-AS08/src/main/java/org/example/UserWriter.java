package org.example;



import org.example.UserOuterClass.User;
import org.example.UserOuterClass.Users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
TODO:Benutzen Sie die Intellij Vorlage und erstellen Sie im Ordner src/main/proto eine Datei users.proto, mit der sie die Daten
 aus Aufgabe 11 speichern können. Schreiben Sie dann eine main-Methode, die die User in eine Datei schreibt (z. B. user.bin)
 und eine andere main-Methode, die diese Datei einliest und die User auf der Konsole ausgibt.
 */
public class UserWriter {
    public static void main(String[] args) {


        Users users = Users.newBuilder()
                .addUsers(User.newBuilder().setId(1).setName("Paul").build())
                .addUsers(User.newBuilder().setId(2).setName("Anna").setAddress("Englerstr. 11").build()).build();

            try(FileOutputStream out = new FileOutputStream("user.bin")){

                users.writeTo(out);
                System.out.println("user in user.bin geschrieben");


            }catch(IOException e){
                System.out.println(e.getMessage());
            }



    }
}
