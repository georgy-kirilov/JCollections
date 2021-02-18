package models;

public class Person
{
    private String name;
    private int age;
    private boolean male;

    public Person(String name, int age, boolean male)
    {
        this.setName(name);
        this.setAge(age);
        this.setMale(male);
    }

    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    public boolean isMale()
    {
        return this.male;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setMale(boolean male)
    {
        this.male = male;
    }
}
