package uk.camsw.cib.bdd;

import org.assertj.core.util.Lists;
import uk.camsw.cib.*;

import java.util.List;
import java.util.concurrent.Executor;

public class World {

    TestPublisher publisher = new TestPublisher();

    /**
     * Decision: To facilitate development and debugging of functionality the majority of the features will run on the single, main thread
     */
    Scheduler scheduler = TestSupport.aSameThreadScheduler();

    InstrumentRefDataService service = new InstrumentRefDataService(new InMemoryInstrumentRepository(), publisher, scheduler);

    public void enqueInbound(LmeInstrumentRefData instrument) {

    }

    public void publishInboundLme(String code) {

    }
}
