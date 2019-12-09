package com.csw.jcs.decoratorpattern;

public class Decorator {

    public static void main(String[] args) {
        Shape food = new RouRou(new Noodles());
        food.describe();
    }

}
