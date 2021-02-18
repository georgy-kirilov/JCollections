package coolcollections;

import delegates.actions.TinyAction;
import delegates.functions.Predicate;
import delegates.functions.TinyFunc;

public interface Queryable<TSource> extends Iterable<TSource>
{
    int count();
    boolean all(Predicate<TSource> filter);
    boolean any(Predicate<TSource> filter);
    TSource first(Predicate<TSource> filter);
    Queryable<TSource> where(Predicate<TSource> filter);
    <TOut> Queryable<TSource> select(TinyFunc<TSource, TOut> selector);
    Queryable<TSource> foreach(TinyAction<TSource> action);
    <TKey extends Comparable<TKey>> Queryable<TSource> sortBy(TinyFunc<TSource, TKey> keySelector);
    <TKey extends Comparable<TKey>> Queryable<TSource> sortByDesc(TinyFunc<TSource, TKey> keySelector);
}
