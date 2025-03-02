package geometry3d;
import exceptions.HeightCylinderException;
import exceptions.FootingCylinderException;
import geometry2d.Figure;

public class Cylinder {
    Figure footing;
    double height;

    public Cylinder(Figure footing, double height) throws FootingCylinderException, HeightCylinderException {
        if (footing.area() < 5)
            throw new FootingCylinderException("The base area is too small");
        this.footing = footing;
        if (height <= 0)
            throw new HeightCylinderException("Height of Cylinder must be positive");
        this.height = height;
    }

    public Figure getFooting() {
        return footing;
    }

    public void setFooting(Figure footing) throws FootingCylinderException {
        if (footing.area() < 5)
            throw new FootingCylinderException("The base area is too small");
        this.footing = footing;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws HeightCylinderException {
        if (height <= 0)
            throw new HeightCylinderException("Height of Cylinder must be positive");
        this.height = height;
    }

    double volume()
    {
        return this.footing.area()*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "footing=" + footing.toString() +
                ", height=" + height +
                ", volume=" + this.volume() +
                '}';
    }
}
