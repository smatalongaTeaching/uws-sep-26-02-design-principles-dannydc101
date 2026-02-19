package com.uws.excercise2;

public class Rectangle implements Shape {
    private double width;
    private double height;
//changed to implement shape class which will contain formulae
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
// changed to in
