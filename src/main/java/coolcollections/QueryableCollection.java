package coolcollections;

import coolcollections.lists.ArrayList;
import coolcollections.lists.List;
import delegates.actions.TinyAction;
import delegates.functions.Predicate;
import delegates.functions.TinyFunc;

import java.util.Iterator;

public abstract class QueryableCollection<TSource> implements Queryable<TSource>
{
    public abstract void clear();
    public abstract Iterator<TSource> iterator();

    @Override
    public int count()
    {
        int count = 0;
        for (TSource item : this)
        {
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty()
    {
        return this.count() <= 0;
    }

    @Override
    public String join()
    {
        return this.joinBy(null);
    }

    @Override
    public String joinBy(String separator)
    {
        separator = separator == null ? ", " : separator;
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (TSource item : this)
        {
            sb.append(item);
            sb.append(separator);
        }
        String result = sb.toString();
        result = result.substring(0, result.length() - separator.length()) + " }";
        return result;
    }

    @Override
    public List<TSource> toList()
    {
        List<TSource> list = new ArrayList<>(this.count());
        for (TSource item : this)
        {
            list.add(item);
        }
        return list;
    }

    @Override
    public boolean contains(TSource item)
    {
        for (TSource current : this)
        {
            if (Helper.areEqual(current, item))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Iterable<TSource> collection)
    {
        boolean allExist = false;
        for (TSource current : collection)
        {
            allExist = false;
            for (TSource next : this)
            {
                if (Helper.areEqual(current, next))
                {
                    allExist = true;
                    break;
                }
            }
        }
        return allExist;
    }

    @Override
    public boolean all(Predicate<TSource> filter)
    {
        for (TSource item : this)
        {
            if (!filter.apply(item))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean any(Predicate<TSource> filter)
    {
        for (TSource item : this)
        {
            if (filter.apply(item))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public TSource first(Predicate<TSource> filter)
    {
        for (TSource item : this)
        {
            if (filter.apply(item))
            {
                return item;
            }
        }
        return null;
    }

    @Override
    public Queryable<TSource> where(Predicate<TSource> filter)
    {
        List<TSource> items = new ArrayList<>(this.count());
        for (TSource item : this)
        {
            if (filter.apply(item))
            {
                items.add(item);
            }
        }
        return items;
    }

    @Override
    public <TOut> Queryable<TOut> select(TinyFunc<TSource, TOut> selector)
    {
        List<TOut> items = new ArrayList<>(this.count());
        for (TSource item : this)
        {
            items.add(selector.apply(item));
        }
        return items;
    }

    @Override
    public Queryable<TSource> foreach(TinyAction<TSource> action)
    {
        for (TSource item : this)
        {
            action.invoke(item);
        }
        return this;
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
}
