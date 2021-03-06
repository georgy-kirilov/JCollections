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
        for (TSource item : this)
        {
            sb.append(item);
            sb.append(separator);
        }
        String result = sb.toString();
        if (result.length() >= separator.length())
        {
            result = result.substring(0, result.length() - separator.length());
        }
        return result;
    }

    @Override
    public List<TSource> toList()
    {
        List<TSource> list = new ArrayList<>();
        for (TSource item : this)
        {
            list.add(item);
        }
        return list;
    }

    @Override
    public Queryable<TSource> reverse()
    {
        List<TSource> list = this.toList();
        int end = list.count() - 1;
        for (int i = 0; i < list.count() / 2; i++)
        {
            TSource current = list.get(i);
            list.set(i, list.get(end - i));
            list.set(end - i, current);
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
        List<TSource> items = new ArrayList<>();
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
        List<TOut> items = new ArrayList<>();
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
        List<TSource> list = this.toList();
        this.sort(keySelector, list, true);
        return list;
    }

    @Override
    public <TKey extends Comparable<TKey>> Queryable<TSource> sortByDesc(TinyFunc<TSource, TKey> keySelector)
    {
        List<TSource> list = this.toList();
        this.sort(keySelector, list, false);
        return list;
    }

    @Override
    public String toString()
    {
        return String.format("[%s]", this.join());
    }

    private <TKey extends Comparable<TKey>> void sort(TinyFunc<TSource, TKey> keySelector, List<TSource> list, boolean ascending)
    {
        for (int i = 0; i < list.count() - 1; i++)
        {
            for (int k = i + 1; k < list.count(); k++)
            {
                TSource current = list.get(i);
                TSource next = list.get(k);
                boolean shouldSwap = ascending && keySelector.apply(current).compareTo(keySelector.apply(next)) > 0 ||
                        !ascending && keySelector.apply(current).compareTo(keySelector.apply(next)) < 0;

                if (shouldSwap)
                {
                    list.set(i, next);
                    list.set(k, current);
                }
            }
        }
    }
}
