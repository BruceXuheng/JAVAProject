package com.csw.jcs.prototypepattern.demo;

import com.csw.jcs.prototypepattern.proto.AbsShape;
import com.csw.jcs.prototypepattern.proto.Circle;
import com.csw.jcs.prototypepattern.proto.Rectangle;
import com.csw.jcs.prototypepattern.proto.Square;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, AbsShape> shapeMap
            = new Hashtable<String, AbsShape>();

    public static AbsShape getShape(String shapeId) {
        AbsShape cachedShape = shapeMap.get(shapeId);
        return (AbsShape) cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, AbsShape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }

}
