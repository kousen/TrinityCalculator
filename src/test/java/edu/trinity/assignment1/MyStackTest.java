package edu.trinity.assignment1;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private final MyStack<String> stack = new MyStack<>();

    @Test
    void push() {
        stack.push("Hello");
        stack.push("World");
        assertEquals("World", stack.peek());
    }

    @Test
    void pop() {
        stack.push("Hello");
        stack.push("World");
        assertEquals("World", stack.pop());
        assertEquals("Hello", stack.pop());
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void peek() {
        stack.push("Hello");
        stack.push("World");
        assertEquals("World", stack.peek());
        assertEquals("World", stack.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("Hello");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}