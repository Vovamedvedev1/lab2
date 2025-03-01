package org.example;

public class Button {
    private int count_clicked;

    public Button(int count_clicked) throws Exception {
        if (count_clicked < 0)
            throw new Exception("The initial number of clicks must be an integer number");
        this.count_clicked = count_clicked;
    }

    public int getCount_clicked() {
        return count_clicked;
    }

    public void setCount_clicked(int count_clicked) throws Exception {
        if (count_clicked < 0)
            throw new Exception("The number of clicks must be an integer number");
        this.count_clicked = count_clicked;
    }

    public void clicked() {
        System.out.println(String.format("count_clicked = %d", ++count_clicked));
    }
}
