package Annotations;

import lombok.NoArgsConstructor;

import java.lang.reflect.*;
/*
TODO: Aufgabe 2 – Annotations implementieren und verwenden
 Stellen Sie sich das folgende Szenario vor: Sie entwickeln ein kleines System zur Verwaltung von Benutzerdaten. Dabei
 sollen bestimmte Felder automatisch validiert werden, ohne dass die Validierungslogik direkt im Code der Klasse steht.
 Stattdessen wollen wir jede Variable, die keinen leeren Wert haben darf, mit einer Annotation markieren.
 a) Implementieren Sie eine Annotation mit dem Namen NotEmpty. Die Annotation soll zur Laufzeit verfügbar sein und für
 Instanz- und Klassenvariablen funktionieren. Außerdem soll die Annotation eine optionale Fehlermeldung enthalten.
 b) Erstellen Sie nun eine User-Klasse mit den folgenden Attributen: Name, E-Mail, ID sowie eine Liste von Strings, in der
 die zuletzt durchgeführten Transaktionen gespeichert werden (oder etwas Ähnliches). Benutzen Sie die von Ihnen
 implementierte Annotation NotEmpty, um die wichtigsten Attribute zu markieren.
 */

@NoArgsConstructor
public class User {

    @NotEmpty(message = "der Name darf nicht leer sein")
    private String name;

    private String eMail;

    @NotEmpty
    private int id;


    @AllowedValue("USER")
    @AllowedValue("ADMIN")
    public String role;

    /*
    TODO: Schreibe eine Methode, welche Reflections benutzt und folgendes kann:

     */
    public void interestingMethod(String myInterestingParameter, int myOtherInterestingParameter) {
        //INFO: annonyme innere Unterklasse von Object
        Object anonymousObject = new Object(){

        };//nur eine anonyme innere Klasse weiß, wo sie definiert wurde
        //Anonyme Klasse -> kennt ihre Umgebung -> funktioniert

        //TODO: - Ermittle zur Laufzeit die aktuelle Klasse
        Class<?> c = anonymousObject.getClass().getEnclosingClass();
        System.out.println("Die Klasse heißt: " + c.getName());

        //TODO: - Ermittle den Namen der aktuell ausgeführten Methode
        Method m = anonymousObject.getClass().getEnclosingMethod();
        System.out.println("Die Methode heißt: " + m.getName());

        //TODO: - Gib Name und Typ aller Parameter der Methode aus

        for(Parameter p : m.getParameters()){
            System.out.println("name vom Parameter: "+ p.getName());
            System.out.println("Typ vom parameter: " + p.getType());
        }


        //TODO: - Bestimme den Rückgabetyp der Methode
        System.out.println("Der Rückgabetyp ist: " + m.getReturnType());

        //TODO: - Liste alle Felder der Klasse auf
        /*INFO: getFields -> alle öffentlichen Felder
                getDeclaredFields -> alle
         */



    }


static void main() {

        User u = new User();
        u.interestingMethod("H",1);

            //TODO: setze die ID von Paul auf 4


        //TODO: prüfe ob das Feld name die Annotation NotEmpty besitzt und printe die Message der Annotation


    }
}
