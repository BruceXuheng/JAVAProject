package com.csw.jcs.decoratorpattern;

// 装饰类
public abstract class FoodD implements Shape {

    private Shape shape;

    public FoodD(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void describe() {

    }

    @Override
    public void price() {

    }
}
