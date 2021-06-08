package ru.vsu.samsonova;

public interface SimpleStack<T> extends Iterable<T>
{
    void push(T value);
    T pop() throws Exception;
    T peek() throws Exception;
}
