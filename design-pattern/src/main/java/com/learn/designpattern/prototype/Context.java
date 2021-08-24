package com.learn.designpattern.prototype;

import java.util.HashMap;

public class Context {

    private final HashMap<String, Shape> map = new HashMap<String, Shape>();

    public Context() {

        map.put("Circle", new Circular());
        map.put("Square", new Square());

    }

    public Shape getShape(String key) {

        Shape shape = map.get(key);
        return (Shape) shape.clone();

    }

}
