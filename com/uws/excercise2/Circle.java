package com.uws.excercise2;

public class Circle implements Shape {
    private double radius;
    //changed to implement shape class which will contain formulae
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

