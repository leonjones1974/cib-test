package uk.camsw.cib;

import java.util.Optional;

/**
 * Assumption: This is the boundary to the core of our app.  Inbound instrument data can be received on multiple threads concurrently
 */
public class InstrumentRefDataService {

    private final InstrumentRepository repository;
    private final InstrumentPublisher publisher;
    private final Scheduler scheduler;

    public InstrumentRefDataService(InstrumentRepository repository, InstrumentPublisher publisher, Scheduler scheduler) {
        if (repository == null) throw new IllegalArgumentException("A repository must be provided");
        if (publisher == null) throw new IllegalArgumentException("A publisher must be provided");
        if (scheduler == null) throw new IllegalArgumentException("A scheduler must be provided");
        this.repository = repository;
        this.publisher = publisher;
        this.scheduler = scheduler;
    }

    /**
     * Decision: As this class does nothing aside from orchestration and side-effects I've opted not to unit test it, preferring to exercise
     * it via the cucumber tests rather than create unit tests that rely on mocking/ stubbing
     */
    public Optional<Instrument> onInstrumentReceived(InstrumentRefData instrument) {
        Key key = instrument.getKey();
        Optional<Instrument> mergedInstrument = repository.find(key).orElse(instrument)
                .flatMap(existing -> MergeStrategy.create(existing, instrument))
                .map(strategy -> strategy.merge(instrument));



        // get the key
        // get the instrument
        // find merge strategy
        // merge
        // store
        // publish
        // this means instrument must retain source    }
    }


}
