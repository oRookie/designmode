package factory.t3;

import factory.Circle;
import factory.Shape;

public class CircleFactory implements  Factory {
    @Override
    public Shape getShappe() {
        return new Circle();
    }
}
