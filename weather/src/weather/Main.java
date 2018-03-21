package weather;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Main {

    static final int NUMBER_OF_TASKS_TO_GENERATE = 100;
    static final int NUMBER_OF_TASKS_TO_EXECUTE = 100;

    public static void main(String[] args) {
        TaskGenerator taskGenerator = new TaskGenerator(NUMBER_OF_TASKS_TO_GENERATE);
        Queue inQueue = new Queue();
        taskGenerator.setInQueue(inQueue);
        taskGenerator.generate();
        TaskExecuter taskExecuter = new TaskExecuter();
        taskExecuter.setInQueue(inQueue);
        Queue outQueue = new Queue();
        taskExecuter.setOutQueue(outQueue);
        taskExecuter.execute(NUMBER_OF_TASKS_TO_EXECUTE);
        Logger logger = new Logger();
        logger.setOutQueue(outQueue);
        logger.print();
    }
}
