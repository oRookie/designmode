package factory;

public class ShapeFactory {
    public static Shape getShape(String type){
        if (type.equalsIgnoreCase("RECTANGLE")) return new Rectangle();
        else if (type.equalsIgnoreCase("SQUARE")) return new Square();
        else if (type.equalsIgnoreCase("CIRCLE")) return new Circle();
        return  null;
    };

}
