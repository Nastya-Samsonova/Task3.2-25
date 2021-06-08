package ru.vsu.samsonova;

import java.util.Iterator;

public class SimpleLinkedListStack<T> implements SimpleStack<T> {
    private static class ListNode<T> {
        public T value;
        public ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(T value) {
            this(value, null);
        }
    }

    private ListNode<T> head = null;
    private int size = 0;


    @Override
    public void push(T value) {
        head = new ListNode<>(value, head);
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return head.value;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public void doubler() throws Exception {
        SimpleLinkedListStack<T> tempStackOne = new SimpleLinkedListStack<>();

        while (!this.isEmpty())
        {
            tempStackOne.push(this.pop());
        }

        while (!tempStackOne.isEmpty())
        {
            T value = tempStackOne.pop();
            this.push(value);
            this.push(value);
        }
    }
    @Override
    public Iterator<T> iterator()
    {
        class LinkedListIterator implements Iterator<T>
        {
            ListNode<T> curr;

            public LinkedListIterator(ListNode<T> head)
            {
                curr = head;
            }

            @Override
            public boolean hasNext()
            {
                return curr != null;
            }

            @Override
            public T next()
            {
                T result = curr.value;
                curr = curr.next;
                return result;
            }
        }
        return new LinkedListIterator(head);
    }
}
