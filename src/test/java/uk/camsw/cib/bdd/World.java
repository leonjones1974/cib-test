package uk.camsw.cib.bdd;

import uk.camsw.cib.InMemoryInstrumentRepository;
import uk.camsw.cib.InstrumentRefDataService;
import uk.camsw.cib.LmeInstrumentRefData;
import uk.camsw.cib.TestPublisher;

public class World {

    TestPublisher publisher = new TestPublisher();
    InstrumentRefDataService service = new InstrumentRefDataService(new InMemoryInstrumentRepository(), publisher);

    public void enqueInbound(LmeInstrumentRefData instrument) {

    }

    public void publishInboundLme(String code) {

    }
}
