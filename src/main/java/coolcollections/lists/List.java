package coolcollections.lists;

import coolcollections.Queryable;

public interface List<T>
{
    void add(T item);
    void addAll(Iterable<T> collection);
    void insert(int index, T item);
    T get(int index);
    void set(int index, T item);
    boolean remove(T item);
    T removeAt(int index);
    int indexOf(T item);
    void clear();
    boolean contains(T item);
    boolean containsAll(Iterable<T> collection);
    List<T> subList(int startIndex, int endIndex);
}
