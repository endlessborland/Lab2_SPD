package weather;

import java.util.concurrent.ThreadLocalRandom;

public class TaskExecuter {

    private Queue inQueue;
    private Queue outQueue;

    public void setInQueue(Queue inQueue) {
        this.inQueue = inQueue;
    }

    public void setOutQueue(Queue outQueue) {
        this.outQueue = outQueue;
    }


    public void execute(int numberOfTasksToExecute) {
        Task tmp;
        for (int i = 0; i < this.inQueue.size(); i++)
        {
            tmp = this.inQueue.getFirstTask();
            this.execTask(tmp);
            this.outQueue.add(tmp);
        }
    }

    private void execTask(Task tmp) {
        int randomNum = ThreadLocalRandom.current().nextInt(-273, 273 + 1);
        tmp.setWeather(randomNum);

    }
}
