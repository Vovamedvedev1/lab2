package org.example;

public class Balance {
    private double left = 0;
    private double right = 0;

    public Balance(double left, double right) throws Exception {
        if (left <= 0 || right <= 0)
            throw new Exception("The weights on the left and right bowls should be positive.");
        this.left = left;
        this.right = right;
    }

    public void addLeft(double left) throws Exception {
        if (left <= 0)
            throw new Exception("You can only add a positive weight to the left side of the scale.");
        this.left += left;
    }

    public void addRight(double right) throws Exception {
        if (right <= 0)
            throw new Exception("You can only add a positive weight to the right side of the scale.");
        this.right += right;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return right;
    }

    public void clear() {
        this.left = 0;
        this.right = 0;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    public void result() {
        char res = Math.abs(this.left - this.right) < Math.pow(10,-10) ? '=' : ((this.left - this.right) > 0 ? '>' : '<');
        System.out.println(String.format("weight_left(%s) %s weight_right(%s)", this.left, res, this.right));
    }

}
