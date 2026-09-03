package com.gmail.alexei28.shortcut.algorithms.module4;
/*
   https://leetcode.com/problems/implement-queue-using-stacks/description/
   232. Implement Queue using Stacks [Easy]
   Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions
   of a normal queue (push, peek, pop, and empty).

   Implement the MyQueue class:
   - void push(int x) Pushes element x to the back of the queue.
   - int pop() Removes the element from the front of the queue and returns it.
   - int peek() Returns the element at the front of the queue.
   - boolean empty() Returns true if the queue is empty, false otherwise.

   Notes:
   You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty
   operations are valid. Depending on your language, the stack may not be supported natively. You may simulate a stack using
   a list or deque (double-ended queue) as long as you use only a stack's standard operations.

    Example 1:
    Input
    ["MyQueue", "push", "push", "peek", "pop", "empty"]
    [[], [1], [2], [], [], []]

    Output
    [null, null, null, 1, 1, false]

    Explanation
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    myQueue.peek(); // return 1
    myQueue.pop(); // return 1, queue is [2]
    myQueue.empty(); // return false

    Требования:
    Временная сложность: O(1) (амортизированная) для всех операций
    Используйте только операции стека (push, pop, peek, empty)

    Подсказка:
    Используйте два стека: один для добавления элементов (input stack), другой для удаления (output stack).
    При pop или peek, если output stack пуст, переместите все элементы из input stack в output stack.
*/

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class MyQueue {
    private Deque<Integer> inputStack;
    private Deque<Integer> outputStack;

    public MyQueue() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    // добавить элемент в конец очереди
    public void push(int x) {
        inputStack.push(x);
    }

    // удалить элемент из начала очереди
    public int pop() {
        moveIfNeeded();
        return outputStack.pop();
    }

    // получить элемент из начала очереди
    public int peek() {
        moveIfNeeded();
        return outputStack.peek();
    }

    // проверить, пуста ли очередь
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void moveIfNeeded() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                int inputStackPopItem = inputStack.pop();
                outputStack.push(inputStackPopItem);
            }
        }
    }
}

