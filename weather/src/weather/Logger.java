package weather;

public class Logger {

    private Queue outQueue;

    public Logger() {
    }


    public void setOutQueue(Queue outQueue) {
        this.outQueue = outQueue;
    }

    public void print()
    {
        Task tmp;
        int outQueueSize = this.outQueue.size();
        for (int i = 0; i < outQueueSize; i++)
        {
            tmp = this.outQueue.getFirstTask();
            System.out.println("ID: " + tmp.getID());
            System.out.println("City: " + tmp.getCity());
            System.out.println("Temperature: " + tmp.getWeather());
            System.out.println("Date " + tmp.getDate());
            System.out.println();
        }
    }
}
