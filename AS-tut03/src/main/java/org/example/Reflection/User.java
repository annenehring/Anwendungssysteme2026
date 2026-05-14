package org.example.Reflection;


public class User extends UserMutter {

    public String name;
    private int age;

    public int getAge() {
        return age;
    }

    public User(){

    }
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
}
