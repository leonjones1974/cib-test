package uk.camsw.cib;

import jdk.nashorn.internal.runtime.options.Option;

public interface InstrumentRepository {

    void store(Instrument instrument);

    // Prime
    // get the instrument
    // find merge strategy
    // merge
    // store
    // publish
    // this means instrument must retain source
    Option<Instrument> find(Key key);



}
