package com.java.design.pattern.main;

enum ShapeType{
    Circle,Rectangle,Square;
}

interface Shape{
    public void draw();
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("This is Circle");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("This is Square");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("This is Rectangle");
    }
}

class ShapeFactory{
    public Shape getShape(ShapeType shapeType){
        switch(shapeType){
            case Circle:
                return new Circle();
            case Rectangle:
                return new Rectangle();
            case Square:
                return new Square();
            default:
                return null;
        }
    }
}

/*
If require object creation multiple times, to remove redundancy create a factory
for it that gives the required object
*/

public class Factory {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape(ShapeType.Circle).draw();
        shapeFactory.getShape(ShapeType.Rectangle).draw();
        shapeFactory.getShape(ShapeType.Square).draw();

    }
}
