package coolcollections.lists;

import coolcollections.QueryableCollection;

public class ArrayList<T> extends QueryableCollection<T> implements List<T>
{
    @Override
    public void add(T item)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addAll(Iterable<T> collection)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(int index, T item)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(int index, T item)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(T item)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public T removeAt(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(T item)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(T item)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Iterable<T> collection)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int startIndex, int endIndex)
    {
        throw new UnsupportedOperationException();
    }
}
