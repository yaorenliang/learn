package com.learn.designpattern.prototype;

/**
 * 形状接口
 *
 * @author 姚壬亮
 */
public interface Shape extends Cloneable {

    /**
     * 拷贝
     *
     * @return 拷贝完成后的新对象
     */
    Object clone();

    /**
     * 计算面积
     */
    void countArea();

}
