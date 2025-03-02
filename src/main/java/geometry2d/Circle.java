package geometry2d;
import exceptions.CircleException;


public class Circle implements Figure {
    private double radius;

    public Circle(double radius) throws CircleException{
        if (radius <= 0)
            throw new CircleException("Radius of Circle must be positive");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws CircleException{
        if (radius <= 0)
            throw new CircleException("Radius of Circle must be positive");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", area=" + this.area() +
                ", perimeter=" + this.perimeter() +
                '}';
    }
}
