package com.uws.excercise3;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Bird simpleBird = new Bird("Generic Bird");
        Bird sparrow = new Sparrow("Jack");
        Bird penguin = new Penguin("Pingu");

        ArrayList<Bird> birds = new ArrayList<>();
        birds.add(simpleBird);
        birds.add(sparrow);
        birds.add(penguin);

        MainClass.letBirdsFly(birds);
        ((Penguin) penguin).swim(); // Now reachable — no exception thrown
    }

    public static void letBirdsFly(List<Bird> birds) {
        for (Bird bird : birds) {
            if (bird instanceof Flyable) {
                ((Flyable) bird).fly(); // Only birds that can fly will fly
            } else {
                System.out.println(bird.getName() + " cannot fly, skipping...");
            }
        }
    }
}

