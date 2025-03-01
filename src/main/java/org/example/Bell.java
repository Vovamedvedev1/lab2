package org.example;

public class Bell {
    private static int countCalls = 0;

    public Bell() {}
    public static void sound() {
        if (countCalls % 2 == 0)
            System.out.println("ding");
        else
            System.out.println("dong");
        countCalls++;
    }
}
