package com.csw.jcs.prototypepattern.proto;

public class Circle extends AbsShape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
