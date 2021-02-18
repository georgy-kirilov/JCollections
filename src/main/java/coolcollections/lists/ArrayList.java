package coolcollections.lists;

import coolcollections.QueryableCollection;
import coolcollections.Helper;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> extends QueryableCollection<T> implements List<T>
{
    public static final int INITIAL_CAPACITY = 4;

    private T[] array;
    private int count;

    public ArrayList(T[] array)
    {
        this(Arrays.asList(array));
    }

    public ArrayList(Iterable<T> collection)
    {
        this();
        this.addAll(collection);
    }

    public ArrayList()
    {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity)
    {
        Helper.throwIfLessThanOrEqualToZero(initialCapacity);
        this.array = (T[]) new Object[initialCapacity];
        this.count = 0;
    }

    @Override
    public void add(T item)
    {
        if (this.count() >= this.capacity())
        {
            this.expand();
        }
        this.array[this.count()] = item;
        this.count++;
    }

    @Override
    public void addAll(Iterable<T> collection)
    {
        for (T item : collection)
        {
            this.add(item);
        }
    }

    @Override
    public void insert(int index, T item)
    {
        this.throwIfOutOfRange(index);
        if (this.count() >= this.capacity())
        {
            this.expand();
        }
        for (int i = this.count(); i > index; i--)
        {
            this.array[i] = this.array[i - 1];
        }
        this.set(index, item);
        this.count++;
    }

    @Override
    public T get(int index)
    {
        this.throwIfOutOfRange(index);
        return this.array[index];
    }

    @Override
    public void set(int index, T item)
    {
        this.throwIfOutOfRange(index);
        this.array[index] = item;
    }

    @Override
    public boolean remove(T item)
    {
        int index = this.indexOf(item);
        if (index >= 0)
        {
            this.removeAt(index);
            return true;
        }
        return false;
    }

    @Override
    public T removeAt(int index)
    {
        T removed = this.get(index);
        for (int i = index; i < this.count() - 1; i++)
        {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
        return removed;
    }

    @Override
    public int indexOf(T item)
    {
        for (int i = 0; i < this.count(); i++)
        {
            if (Helper.areEqual(this.array[i], item))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<T> subList(int startIndex, int endIndex)
    {
        ArrayList<T> subList = new ArrayList<T>();
        for (int i = startIndex; i <= endIndex; i++)
        {
            subList.add(this.get(i));
        }
        return subList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear()
    {
        this.array = (T[]) new Object[INITIAL_CAPACITY];
        this.count = 0;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private int index = 0;

            @Override
            public boolean hasNext()
            {
                return this.index < count();
            }

            @Override
            public T next()
            {
                T next = array[index];
                this.index++;
                return next;
            }
        };
    }
    @Override
    public int count()
    {
        return this.count;
    }

    public int capacity()
    {
        return this.array.length;
    }

    @SuppressWarnings("unchecked")
    private void expand()
    {
        T[] copy = (T[]) new Object[this.capacity() * 2];
        for (int i = 0; i < this.capacity(); i++)
        {
            copy[i] = this.array[i];
        }
        this.array = copy;
    }

    private void throwIfOutOfRange(int index)
    {
        if (index < 0 || index >= this.count())
        {
            throw new IllegalArgumentException("Index was outside the list bounds");
        }
    }
}
