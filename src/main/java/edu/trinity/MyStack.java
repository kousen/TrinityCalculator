package edu.trinity;

import java.util.EmptyStackException;

public class MyStack<T> {

    private final int MAX_SIZE = 1000;
    private T[] stackArray;
    private int size;

    public MyStack()
    {
        stackArray = (T[])new Object[MAX_SIZE];
        size = 0;
    }
    public void push(T obj) {
        stackArray[size] = obj;
        size++;
    }
    public T peek() {
        return stackArray[size - 1];
    }

    public T pop() {
        if (size == 0)
            throw new EmptyStackException();
        size--;
        T popped = stackArray[size];
        stackArray[size] = null;
        return popped;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
