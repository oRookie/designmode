package factory.t3;

import factory.Shape;

/**
 *  工厂方法模式
 */
public class ShapeMainTest {
    public static void main(String[] args) {
        Factory factory = new CircleFactory();
        Shape shappe = factory.getShappe();
        shappe.draw();
    }
}
