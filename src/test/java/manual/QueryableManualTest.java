package manual;

import coolcollections.lists.ArrayList;
import coolcollections.lists.List;
import models.Person;

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
        numbers.addAll(Arrays.asList(new Integer[]{ 10, 2, 6, 1, 5, 0}));
        numbers.add(15);
        numbers.add(-5);

        output = numbers.sortByDesc(n -> n * n).reverse().toString();
        System.out.println(output);

        List<Person> people = new ArrayList<>(new Person[]
        {
            new Person("Ivan", 25, true),
            new Person("Simeon", 34, true),
            new Person("Anna", 40, false),
            new Person("John", 15, true),
            new Person("Jane", 12, false),
        });

        output = people.where(p -> p.getAge() >= 18 && p.isMale())
                    .foreach(p -> p.setName(p.getName().toUpperCase()))
                    .sortByDesc(p -> p.getAge())
                    .select(p -> String.format("%s, %d", p.getName(), p.getAge()))
                    .joinBy("\n");

        System.out.println(output);
    }
}
