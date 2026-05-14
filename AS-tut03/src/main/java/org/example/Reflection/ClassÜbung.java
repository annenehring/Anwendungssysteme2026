package org.example.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassÜbung {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        //TODO: Hole die Klasse User über .class (Tipp: nutze <>)
        Class<User> clazz = User.class;

        //TODO: Hole die Klasse eines Objekts user
        User user = new User();
        Class<?> clazz2 = user.getClass();

        //TODO: Hole die Superklasse von User
        Class<?> mutter = User.class.getSuperclass();

        //TODO: Hole alle deklarierten Felder der Klasse User
        // (eines der Felder ist privat)
        Field[] arr = User.class.getDeclaredFields();
        for(Field f : User.class.getDeclaredFields()){
            f.setAccessible(true);
            System.out.println("Name des Feldes: "+ f.getName());
        }
        //TODO:Hole ein bestimmtes Feld name
        Field feldName = clazz.getDeclaredField("name");

        //TODO: Setze den Wert des Feldes name auf Max
        feldName.setAccessible(true);
        feldName.set(user,"Max");

        //TODO: Hole den Konstruktor der Klasse --> anspruchsvoll, aber nur eine Zeile
        Constructor<User> con = User.class.getDeclaredConstructor(String.class, int.class);

        //TODO: Erzeuge eine neue Instanz über Reflection
        User user2 = con.newInstance("Max", 5);
        System.out.println("Neue Instanz: " + user2.name);
    }


}
