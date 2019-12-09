package com.csw.jcs.prototypepattern.demo;

import com.csw.jcs.prototypepattern.proto.AbsShape;
import com.csw.jcs.prototypepattern.proto.Circle;

public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        AbsShape clonedShape = ShapeCache.getShape("1");
        clonedShape.setId("2");
        System.out.println("AbsShape : " + clonedShape.getType()+" "+ clonedShape.getType().hashCode()+" id="+clonedShape.getId());
        System.out.println("AbsShape : " + System.identityHashCode(clonedShape.hashCode()));
        System.out.println("------------------------------------------------------------------");

//        AbsShape clonedShape2 = ShapeCache.getShape("2");
//        System.out.println("AbsShape : " + clonedShape2.getType());
//        System.out.println("------------------------------------------------------------------");
//
//        AbsShape clonedShape3 = ShapeCache.getShape("3");
//        System.out.println("AbsShape : " + clonedShape3.getType());
//        System.out.println("------------------------------------------------------------------");
//



        AbsShape clonedShape1 = ShapeCache.getShape("1");
        System.out.println("AbsShape : " + clonedShape1.getType()+" "+ clonedShape1.getType().hashCode()+" id = "+clonedShape1.getId());
        System.out.println("AbsShape : " + System.identityHashCode(clonedShape1.hashCode()));
        System.out.println("------------------------------------------------------------------");
        System.out.println("AbsShape : " + clonedShape1.equals(clonedShape));

        AbsShape clonedShape2 = (AbsShape) clonedShape.clone();
        clonedShape2.setId("5555");
        System.out.println("AbsShape : " + clonedShape2.getType()+" "+ clonedShape2.getType().hashCode()+" id = "+clonedShape2.getId());
        System.out.println("AbsShape : " + clonedShape.getType()+" "+ clonedShape.getType().hashCode()+" id="+clonedShape.getId());


//        Circle shape = new Circle();
//        System.out.println(shape.getType().hashCode());
//        Circle circle = (Circle) shape.clone();
//        System.out.println(circle.getType().hashCode());

    }

}
