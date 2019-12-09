package com.csw.jcs.decoratorpattern;

public class Noodles implements Shape{


    @Override
    public void describe() {
        System.out.println("一碗热面 ");
    }

    @Override
    public void price() {
        System.out.println("现价 : 30元");
    }


}
