package ru.vsu.samsonova;

public class Main {

    public static void main(String[] args) throws Exception {
	SimpleLinkedListStack<String> stack = new SimpleLinkedListStack<>();
	stack.push("one");
	stack.push("two");
	stack.push("three");

    for(String n : stack)
    {
        System.out.println(n);
    }
        System.out.println("__________________________________________________");

    stack.doubler();

        for(String n : stack)
        {
            System.out.println(n);
        }
    }
}
