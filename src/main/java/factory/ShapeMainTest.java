package factory;

public class ShapeMainTest {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("RECTANGLE");
        Shape shape1 = ShapeFactory.getShape("SQUARE");
        Shape shape2 = ShapeFactory.getShape("CIRCLE");
        shape.draw();
        shape1.draw();
        shape2.draw();
    }
}
