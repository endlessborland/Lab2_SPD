package weather;

import java.util.ArrayDeque;

public class Queue {

    protected ArrayDeque<Task> queue;

    public Queue() {
        queue = new ArrayDeque<Task>();
    }

    public Task getFirstTask() {
        return this.queue.pollFirst();
    }

    public int size()
    {
        return this.queue.size();
    }

    public void add(Task tmp) {
        this.queue.add(tmp);
    }
}
