package manual;

import coolcollections.lists.ArrayList;
import coolcollections.lists.List;

public class QueryableManualTest
{
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<>(new String[] { "Ivan", "John", "Simon", "Alexander" });
        names.add("Shrek");

        String output = names.where(n -> n.toLowerCase().contains("s")).join();
        System.out.println(output);
    }
}
