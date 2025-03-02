package org.example;
import exceptions.CircleException;
import exceptions.RectException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry2d.Figure;
import geometry3d.Cylinder;

import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------Task 1----------------------------------");
        Button button = null;
        try {
            button = new Button(17);
            System.out.println("Start count clicked = " + String.valueOf(button.getCount_clicked()));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (button != null) {
            button.clicked();
            button.clicked();
            try {
                button.setCount_clicked(10);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            button.clicked();
            button.clicked();
            System.out.println("Itog count clicked = " + String.valueOf(button.getCount_clicked()));
        }
        System.out.println("-------------------------Task 2----------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input weight1: ");
        double weight1 = scanner.nextDouble();
        System.out.print("Input weight2: ");
        double weight2 = scanner.nextDouble();
        Balance balance = null;
        try {
            balance = new Balance(weight1, weight2);
            System.out.println("The start position of the scales: " + balance.toString());
            balance.result();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (balance != null) {
            try
            {
                balance.addLeft(123.6798);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            try
            {
                balance.addRight(15.72);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            try
            {
                balance.addLeft(121.745);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            try
            {
                balance.addRight(308.256);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            System.out.println("The second position of the scales: " + balance.toString());
            balance.result();
            balance.clear();
            try
            {
                balance.addLeft(11.6798);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            try
            {
                balance.addRight(13.254);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            try
            {
                balance.addLeft(18.678);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            try
            {
                balance.addRight(17.1038);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            System.out.println("The third position of the scales: " + balance.toString());
            balance.result();
        }
        System.out.println("-------------------------Task 3----------------------------------");
        Bell.sound();
        Bell.sound();
        Bell.sound();
        Bell.sound();
        Bell.sound();
        Bell.sound();
        Bell.sound();
        Bell.sound();
        Bell.sound();
        Bell.sound();
        Bell bell = new Bell();
        bell.sound();
        System.out.println("-------------------------Task 4----------------------------------");
        OddEvenSeparator oes = new OddEvenSeparator(Arrays.asList(11,324,16, 18,246, 789,236, 12,683));
        oes.addNumber(412);
        oes.addNumber(816);
        oes.addNumber(11);
        oes.addNumber(816);
        oes.addNumber(46);
        oes.addNumber(58);
        oes.addNumber(13);
        oes.addNumber(26);
        oes.addNumber(412);
        oes.delete(new HashSet<Integer>(Arrays.asList(11,816,412)));
        oes.odd();
        oes.even();
        System.out.println("-------------------------Task 5----------------------------------");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Table 1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("Input count rows in table 1: ");
        int n = scanner.nextInt();
        System.out.print("Input count cols in table 1: ");
        int m = scanner.nextInt();
        Table tb1 = new Table(n, m);
        for (int i=0; i < n; i++)
            for (int j=0; j < m; j++)
                tb1.setValue(i,j,scanner.nextInt());
        System.out.println("Count rows: " + tb1.rows());
        System.out.println("Count cols: " + tb1.cols());
        System.out.println("tb1[n-1][m-1] = " + tb1.getValue(n-1, m-1));
        System.out.println(tb1);
        System.out.println("The average value = " + tb1.average());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Table 2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("Input count rows in table 2: ");
        int n1 = scanner.nextInt();
        System.out.print("Input count cols in table 1: ");
        int m1 = scanner.nextInt();
        Table tb2 = new Table(n1, m1);
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < m1; j++)
                tb2.setValue(i,j,scanner.nextInt());
        System.out.println("Count rows: " + tb2.rows());
        System.out.println("Count cols: " + tb2.cols());
        System.out.println("tb2[n-1][m-1] = " + tb2.getValue(n1-1, m1-1));
        System.out.println(tb2);
        System.out.println("The average value = " + tb2.average());
        System.out.println("---tb3 = tb1*tb2---");
        //Table tb3 = tb1.calculate(tb2, '+');
        System.out.println("-------------------------Task 6----------------------------------");
        Figure[] figures = new Figure[6];
        for (int i = 0; i < 6; i++)
        {
            if (i % 2 == 0)
            {
                try {
                    figures[i] = new Rectangle(i+6, i+7);
                } catch (RectException e) {
                    System.out.println(e.getMessage());
                }
            }
            else
            {
                try {
                    figures[i] = new Circle(i+9);
                } catch (CircleException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("--------------------------------------------------------------");
            if (figures[i] != null)
                System.out.println(figures[i].toString());
            System.out.println("--------------------------------------------------------------");
        }
        Cylinder cyl1 = null;
        try {
            cyl1 = new Cylinder(new Circle(11.6), 18.7);
            System.out.println("--------------------------------------------------------------");
            System.out.println(cyl1.toString());
            System.out.println("--------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (cyl1 != null)
        try {
            cyl1.setFooting(new Rectangle(11.7, 18.3));
            cyl1.setHeight(11.7);
            System.out.println("--------------------------------------------------------------");
            System.out.println(cyl1.toString());
            System.out.println("--------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}