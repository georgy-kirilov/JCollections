package coolcollections;

import delegates.actions.TinyAction;
import delegates.functions.Predicate;
import delegates.functions.TinyFunc;

import java.util.Iterator;

public abstract class QueryableCollection<TSource> implements Queryable<TSource>
{
    @Override
    public int count()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean all(Predicate<TSource> filter)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean any(Predicate<TSource> filter)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public TSource first(Predicate<TSource> filter)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Queryable<TSource> where(Predicate<TSource> filter)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <TOut> Queryable<TSource> select(TinyFunc<TSource, TOut> selector)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Queryable<TSource> foreach(TinyAction<TSource> action)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <TKey extends Comparable<TKey>> Queryable<TSource> sortBy(TinyFunc<TSource, TKey> keySelector)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <TKey extends Comparable<TKey>> Queryable<TSource> sortByDesc(TinyFunc<TSource, TKey> keySelector)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract Iterator<TSource> iterator();
}
