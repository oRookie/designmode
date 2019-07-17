package factory.t2;

import factory.Circle;
import factory.Rectangle;
import factory.Shape;
import factory.Square;

/**
 * 第二种：多个方法
 * 对普通工厂模式的改进，
 */
public class ShapeFactory {
    public static Shape getRectangle(){
        return new Rectangle();
    };
    public static Shape getCircle (){
        return new Circle();
    };
    public static Shape getSquare(){
        return new Square();
    };

    public static void main(String[] args) {
        Shape shape = ShapeFactory.getRectangle();
        Shape shape1 = ShapeFactory.getCircle();
        Shape shape2 = ShapeFactory.getSquare();
        shape.draw();
        shape1.draw();
        shape2.draw();
    }
}
