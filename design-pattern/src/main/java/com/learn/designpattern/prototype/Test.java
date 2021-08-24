package com.learn.designpattern.prototype;

/**
 * 原型模式的克隆分为浅克隆和深克隆
 * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址
 * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址
 * Java 中的 Object 类提供了浅克隆的 clone() 方法，具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，这里的 Cloneable 接口就是抽象原型类
 *
 * @author 姚壬亮
 */
public class Test {

    public static void main(String[] args) {

        Context context = new Context();
        Shape shape1 = context.getShape("Circle");
        shape1.countArea();
        Shape shape2 = context.getShape("Square");
        shape2.countArea();

    }

}
