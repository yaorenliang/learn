package com.learn.designpattern.prototype;

import javafx.scene.shape.Circle;

import java.util.Scanner;

/**
 * 圆形
 *
 * @author 姚壬亮
 */
public class Circular implements Shape {

    @Override
    public Object clone() {

        Circle circle = null;
        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return circle;

    }

    @Override
    public void countArea() {

        int r = 0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积=" + 3.1415 * r * r + "\n");

    }

}
