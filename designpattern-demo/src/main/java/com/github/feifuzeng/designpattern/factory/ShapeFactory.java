package com.github.feifuzeng.designpattern.factory;

import com.github.feifuzeng.designpattern.factory.impl.Circle;
import com.github.feifuzeng.designpattern.factory.impl.Rectangle;
import com.github.feifuzeng.designpattern.factory.impl.Square;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 装饰器模式示例-工厂定义
 * @createTime 2019年04月16日 16:21:00
 */
public class ShapeFactory {

    /** 使用 getShape 方法获取形状类型的对象*/
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}