package manual;

import coolcollections.lists.ArrayList;
import coolcollections.lists.List;

import java.util.Arrays;

public class QueryableManualTest
{
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<>(new String[] { "Ivan", "John", "Simon", "Alexander" });
        names.add("Shrek");

        String output = names.where(n -> n.toLowerCase().contains("s")).select(n -> n.toUpperCase()).toString();
        System.out.println(output);

        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(new Integer[]{ 10, 2, 6, 1, 5}));
        numbers.add(15);
        numbers.add(-5);

        output = numbers.sortByDesc(n -> n * n).toString();
        System.out.println(output);
    }
}
