package com.java.design.pattern.main;

enum ShapeType{
    CIRCLE,RECTANGLE,SQUARE;
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
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
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
        shapeFactory.getShape(ShapeType.CIRCLE).draw();
        shapeFactory.getShape(ShapeType.RECTANGLE).draw();
        shapeFactory.getShape(ShapeType.SQUARE).draw();

    }
}
