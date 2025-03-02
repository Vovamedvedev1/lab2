package geometry2d;

import exceptions.RectException;

public class Rectangle implements Figure{
    private double length;
    private double width;

    public Rectangle(double length, double width) throws RectException {
        if (length <= 0)
            throw new RectException("Length of Rectangle must be positive");
        this.length = length;
        if (width <= 0)
            throw new RectException("Width of Rectangle must be positive");
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) throws RectException {
        if (length <= 0)
            throw new RectException("Length of Rectangle must be positive");
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws RectException{
        if (width <= 0)
            throw new RectException("Width of Rectangle must be positive");
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter()
    {
        return 2*(length+width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", area=" + this.area() +
                ", perimeter=" + this.perimeter() +
                '}';
    }
}
