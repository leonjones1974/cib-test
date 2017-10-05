package uk.camsw.cib;

import jdk.nashorn.internal.runtime.options.Option;

public class InMemoryInstrumentRepository implements InstrumentRepository {
    @Override
    public void store(Instrument instrument) {

    }

    @Override
    public Option<Instrument> find(Key key) {
        return null;
    }
}
