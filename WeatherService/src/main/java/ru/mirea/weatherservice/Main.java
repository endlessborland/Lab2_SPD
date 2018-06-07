package ru.mirea.weatherservice;
import ru.mirea.weatherdata.DataSource;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.concurrent.TimeUnit;


import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Main {

    static final int NUMBER_OF_TASKS_TO_GENERATE = 100;
    static final int NUMBER_OF_TASKS_TO_EXECUTE = 100;
    static final int NUMBER_OF_EXECUTERS = 10;

    public static void main(String[] args) throws InterruptedException {
        DataSource dataSource = new DataSource();
        TaskGenerator taskGenerator = new TaskGenerator(NUMBER_OF_TASKS_TO_GENERATE);
        Queue inQueue = new Queue();
        taskGenerator.setInQueue(inQueue);
        taskGenerator.generate();
        TaskExecuter[] taskExecuters = new TaskExecuter[10];
        Queue outQueue = new Queue();
        for (int i = 0; i < taskExecuters.length; i++)
        {
            taskExecuters[i] = new TaskExecuter();
            taskExecuters[i].setInQueue(inQueue);
            taskExecuters[i].setOutQueue(outQueue);
            taskExecuters[i].setSource(dataSource);
            taskExecuters[i].start();
        }
        while(inQueue.size() != 0)
            Thread.yield();
        Logger logger = new Logger();
        logger.setOutQueue(outQueue);
        logger.print();

    }
}
