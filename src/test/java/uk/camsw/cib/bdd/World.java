package uk.camsw.cib.bdd;

import uk.camsw.cib.*;

public class World {

    TestPublisher publisher = new TestPublisher();

    /**
     * Decision: To facilitate development and debugging of functionality the majority of the features will run on the single, main thread
     */
    Scheduler scheduler = TestSupport.aSameThreadScheduler();

    InstrumentRefDataService service = new InstrumentRefDataService(new InMemoryInstrumentRepository(), publisher, scheduler);

    public void enqueueInbound(LmeInstrumentRefData instrument) {

    }

    public void publishInboundLme(String code) {

    }
}
