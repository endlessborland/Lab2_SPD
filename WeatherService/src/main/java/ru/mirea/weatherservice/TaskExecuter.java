package ru.mirea.weatherservice;

import ru.mirea.weatherdata.DataSource;

import javax.xml.crypto.Data;
import java.util.concurrent.ThreadLocalRandom;

public class TaskExecuter extends Thread{

    private Queue inQueue;
    private Queue outQueue;
    private DataSource source;

    public void setSource(DataSource source)
    {
        this.source = source;
    }

    public void setInQueue(Queue inQueue) {
        this.inQueue = inQueue;
    }

    public void setOutQueue(Queue outQueue) {
        this.outQueue = outQueue;
    }

    @Override
    public void run()
    {
        Task tmp;
        while (this.inQueue.size() != 0) {
            tmp = this.inQueue.getFirstTask();
            this.execTask(tmp);
            this.outQueue.add(tmp);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { return; }
        }
    }

    /* public void execute(int numberOfTasksToExecute) {
         Task tmp;
         for (int i = 0; i < this.inQueue.size(); i++)
         {
             tmp = this.inQueue.getFirstTask();
             this.execTask(tmp);
             this.outQueue.add(tmp);
         }
     }
 */
    private void execTask(Task tmp) {
        tmp.setWeather(source.fetchWeather(tmp.getCity(), tmp.getDate()));
    }
}