package com.csw.jcs.decoratorpattern;

public class RouRou extends FoodD{

    public RouRou(Shape shape) {
        super(shape);

    }

    @Override
    public void describe() {
        System.out.println("加一碗肉肉");
    }

    @Override
    public void price() {
        super.price();
        System.out.println("价格：+ 10元");
    }
}
