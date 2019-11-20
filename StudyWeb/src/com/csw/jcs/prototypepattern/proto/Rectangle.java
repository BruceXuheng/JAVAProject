package com.csw.jcs.prototypepattern.proto;

public class Rectangle extends AbsShape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
