package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class OddEvenSeparator {
    private List<Integer> evens = null;
    private List<Integer> odds = null;

    public OddEvenSeparator() {
        this.odds = null;
        this.evens = null;
    }

    public OddEvenSeparator(List<Integer> numbers) {
        this.evens = new ArrayList<>();
        this.odds = new ArrayList<>();
        for (int d : numbers) {
            if (d % 2 == 0)
                evens.add(d);
            else
                odds.add(d);
        }
    }

    void addNumber(Integer number) {
        if (number % 2 == 0)
            evens.add(number);
        else
            odds.add(number);
    }

    void delete(Set<Integer>setToRemove) {
        this.evens.removeAll(setToRemove);
        this.odds.removeAll(setToRemove);
    }

    void even()
    {
        String evenNumbers = "Even numbers from list: ";
        for (int d : this.evens)
            evenNumbers += (String.valueOf(d) + " ");
        System.out.println(evenNumbers);
    }

    void odd()
    {
        String oddNumbers = "Odd numbers from list: ";
        for (int d : this.odds)
            oddNumbers += (String.valueOf(d) + " ");
        System.out.println(oddNumbers);
    }
}
