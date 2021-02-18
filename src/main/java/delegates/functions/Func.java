package delegates.functions;

public interface Func<T, U, TOut>
{
    TOut apply(T first, T second);
}
