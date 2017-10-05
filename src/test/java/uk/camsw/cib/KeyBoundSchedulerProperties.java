package uk.camsw.cib;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class KeyBoundSchedulerProperties {

    /**
     * Decision: I opted to use property testing as it felt more comprehensive and it's something I am using more frequently in the scala world.
     * It's the kind of thing I'd expect to discuss while pairing though as I do think it adds complexity
     */
    @Property(trials = 10)
    public void workIsBoundToAThreadByKey(@InRange(minInt = 1, maxInt = 12) int noOfExecutors, String strKey) {
        int workCount = 100;

        KeyBoundScheduler scheduler = createScheduler(noOfExecutors);
        List<Future<Long>> results = Stream.generate(() -> strKey)
                .limit(workCount)
                .map(Key::new)
                .map(key -> scheduler.schedule(key, () -> Thread.currentThread().getId()))
                .collect(Collectors.toList());

        assertThat(results.size()).isEqualTo(workCount);
        assertThat(utilisedThreads(results).size()).isEqualTo(1);
    }

    @Test
    public void workIsDistributedAcrossThreads() {
        int noOfExecutors = 3;
        int uniqueKeyCount = 100;

        KeyBoundScheduler scheduler = createScheduler(noOfExecutors);
        List<Future<Long>> results = Stream.generate(() -> UUID.randomUUID().toString())
                .limit(uniqueKeyCount)
                .map(Key::new)
                .map(key -> scheduler.schedule(key, () -> Thread.currentThread().getId()))
                .collect(Collectors.toList());

        assertThat(results.size()).isEqualTo(uniqueKeyCount);
        assertThat(utilisedThreads(results).size()).isEqualTo(noOfExecutors);
    }

    private KeyBoundScheduler createScheduler(int noOfExecutors) {
        List<ExecutorService> executors = Stream.generate(Executors::newSingleThreadExecutor)
                .limit(noOfExecutors)
                .collect(Collectors.toList());
        return new KeyBoundScheduler(executors);
    }

    private Set<Long> utilisedThreads(List<Future<Long>> results) {
        return results.stream()
                .map(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toSet());
    }

}

