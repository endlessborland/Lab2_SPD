package ru.mirea.weatherservice;

import java.util.Date;
import java.util.Random;

public class TaskGenerator {

    public void setInQueue(Queue inQueue) {
        this.inQueue = inQueue;
    }

    private Queue inQueue;
    private int numberOfTasksToGenerate;

    public TaskGenerator(Queue inQueue) {
        this.inQueue = inQueue;
    }

    public TaskGenerator(int numberOfTasksToGenerate)
    {
        this.numberOfTasksToGenerate = numberOfTasksToGenerate;
    }

    public void generate()
    {
        Task t;
        RandomString rs = new RandomString(10);
        Random rnd;
        long ms;
        // Get a new random instance, seeded from the clock
        rnd = new Random();
        for (int i = 0; i < this.numberOfTasksToGenerate; i++) {
            t = new Task(i);
            // Get an Epoch value roughly between 1940 and 2010
            // -946771200000L = January 1, 1940
            // Add up to 70 years to it (using modulus on the next long)
            ms = -946771200000L + (Math.abs(rnd.nextLong()) % (100L * 365 * 24 * 60 * 60 * 1000));
            // Construct a date
            t.setCity(rs.nextString());
            t.setDate(new Date(ms));
            this.inQueue.add(t);
        }
    }

}
