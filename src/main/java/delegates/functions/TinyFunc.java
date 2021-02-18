package delegates.functions;

public interface TinyFunc<T, TOut>
{
    TOut apply(T argument);
}
