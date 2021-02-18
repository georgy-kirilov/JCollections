package coolcollections.stacks;

import coolcollections.Queryable;

public interface Stack<T> extends Queryable<T>
{
    void push(T item);
    T pop();
    T peek();
    boolean empty();
    int search();
}
