package uk.camsw.cib;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class KeyBoundScheduler implements Scheduler {

    private List<ExecutorService> executors;

    public KeyBoundScheduler(List<ExecutorService> executors) {
        if (executors == null || executors.isEmpty()) throw new IllegalArgumentException("You must provide at least one executor");
        this.executors = executors;
    }

    public <T> Future<T>schedule(Key key, Callable<T> work) {
        return executors.get(executorIndexFor(key)).submit(work);
    }

    private int executorIndexFor(Key key) {
        return Math.abs(key.hashCode() % executors.size());
    }
}
