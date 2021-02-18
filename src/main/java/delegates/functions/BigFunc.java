package delegates.functions;

public interface BigFunc<T, U, V, TOut>
{
    TOut apply(T first, U second, V third);
}
