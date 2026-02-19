package com.uws.excercise3;

//implement flyable
public class Sparrow extends Bird implements Flyable {
    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying high and gracefully...");
    }
}

