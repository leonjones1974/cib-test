package uk.camsw.cib.bdd;

import uk.camsw.cib.Instrument;
import uk.camsw.cib.Key;
import uk.camsw.cib.Market;
import uk.camsw.cib.Scheduler;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TestSupport {

    public static Instrument aTradableInstrument() {
        return anInstrument(true);
    }

    public static Instrument aNonTradableInstrument() {
        return anInstrument(false);
    }

    private static Instrument anInstrument(boolean tradable) {
        return new Instrument(LocalDate.now(), LocalDate.now().plusDays(1), new Market("a_market"), "a_label", tradable);
    }

    public static Key aRandomKey() {
        return new Key(UUID.randomUUID().toString());
    }

    public static Scheduler aSameThreadScheduler() {
        return new Scheduler() {
            @Override
            public <T> Future<T> schedule(Key key, Callable<T> work) {
                try {
                return CompletableFuture.completedFuture(work.call());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

}
