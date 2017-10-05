package uk.camsw.cib;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryInstrumentRepository implements InstrumentRepository {

    /**
     * Decision: In the absence of NFR's I've just gone with the default initialisation params
     */
    private final Map<Key, Instrument> store = new ConcurrentHashMap<>();

    @Override
    public void store(Key key, Instrument instrument) {
        store.put(key, instrument);
    }

    @Override
    public Optional<Instrument> find(Key key) {
        return store.containsKey(key) ? Optional.of(store.get(key)) : Optional.empty();
    }
}
