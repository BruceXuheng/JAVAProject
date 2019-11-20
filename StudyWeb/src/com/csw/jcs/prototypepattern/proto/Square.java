package com.csw.jcs.prototypepattern.proto;

public class Square extends AbsShape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}