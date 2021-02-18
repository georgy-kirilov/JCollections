package coolcollections;

public class Helper
{
    private Helper() { }

    public static void throwIfLessThanOrEqualToZero(int value)
    {
        if (value <= 0)
        {
            throw new IllegalArgumentException("Value cannot be less than or equal to zero");
        }
    }

    public static <T> boolean areEqual(T first, T second)
    {
        return first == null && second == null || first != null && first.equals(second);
    }
}
