package ru.mirea.weatherservice;

import java.util.ArrayDeque;

public class Queue {

    protected ArrayDeque<Task> queue;

    public Queue() {
        queue = new ArrayDeque<Task>();
    }

    public synchronized Task getFirstTask() {
        return this.queue.pollFirst();
    }

    public int size()
    {
        return this.queue.size();
    }

    public synchronized void add(Task tmp) {
        this.queue.add(tmp);
    }
}