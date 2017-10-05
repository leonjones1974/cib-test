package uk.camsw.cib;

import java.util.Optional;

public interface InstrumentRepository {

    void store(Key key, Instrument instrument);

    // Prime
    // get the instrument
    // find merge strategy
    // merge
    // store
    // publish
    // this means instrument must retain source
    Optional<Instrument> find(Key key);



}
