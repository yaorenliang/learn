package com.learn.designpattern.singleton;

import java.util.Random;

/**
 * 随机数生成器单例
 *
 * @author 姚壬亮
 **/
public class RandomSingleton {

    private static volatile Random random;

    private RandomSingleton() {

    }

    public static Random get() {

        if (random == null) {
            synchronized (RandomSingleton.class) {
                if (random == null) {
                    random = new Random();
                }
            }
        }
        return random;

    }

}
