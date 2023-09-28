package edu.trinity.assignment1;

import java.util.EmptyStackException;
import java.util.ArrayList;
import java.util.List;

// This implementation uses an ArrayList<T> to store the items of type T.
// That means adding and removing items at the end is quick and easy.
public class MyStack<T> {
    private final List<T> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
