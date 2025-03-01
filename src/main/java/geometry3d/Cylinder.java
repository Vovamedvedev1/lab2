package geometry3d;
import geometry2d.Figure;

public class Cylinder {
    Figure footing;
    double height;

    public Cylinder(Figure footing, double height) {
        this.footing = footing;
        this.height = height;
    }

    public Figure getFooting() {
        return footing;
    }

    public void setFooting(Figure footing) {
        this.footing = footing;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    double volume()
    {
        return this.footing.area()*height;
    }
}
