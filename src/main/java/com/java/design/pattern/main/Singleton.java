package com.java.design.pattern.main;


import java.util.Objects;

class SingletonDemo{
    private static SingletonDemo singletonObj = null;

    private SingletonDemo(){

    }

    public static SingletonDemo getSingletonInstance(){
        synchronized (SingletonDemo.class) {
            if (Objects.isNull(singletonObj)) {
                singletonObj = new SingletonDemo();
            }
        }
        return singletonObj;
    }

}

public class Singleton {

    public static void main(String[] args) {
        System.out.println(SingletonDemo.getSingletonInstance());
        System.out.println(SingletonDemo.getSingletonInstance());

    }
}
