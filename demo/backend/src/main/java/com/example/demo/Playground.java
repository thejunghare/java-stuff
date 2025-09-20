package com.example.demo;

public class Playground {
    // attributes
    int age = 24;

    // method
    public int sum() {
        return this.age + 10;
    }

    public static void main(String[] agrs) {
        Playground obj = new Playground();
        System.out.println(obj.sum());
    }
}
