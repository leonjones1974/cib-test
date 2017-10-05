package uk.camsw.cib;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface Scheduler {
    <T> Future<T> schedule(Key key, Callable<T> work);
}
