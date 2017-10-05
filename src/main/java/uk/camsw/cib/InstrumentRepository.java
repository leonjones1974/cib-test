package uk.camsw.cib;

import java.util.Optional;

public interface InstrumentRepository {

    void store(Key key, Instrument instrument);


    Optional<Instrument> find(Key key);



}
