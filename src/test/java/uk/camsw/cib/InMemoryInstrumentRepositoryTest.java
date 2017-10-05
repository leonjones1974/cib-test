package uk.camsw.cib;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.camsw.cib.bdd.TestSupport.*;

public class InMemoryInstrumentRepositoryTest {

    private InMemoryInstrumentRepository repository;

    @Before
    public void before() {
        repository = new InMemoryInstrumentRepository();
    }

    @Test
    public void itShouldReturnNoneWhereNoInstrumentIsFound() {
        Optional<Instrument> result = repository.find(aRandomKey());
        assertThat(result).isEmpty();
    }

    @Test
    public void itShouldReturnSomeWhereInstrumentHasBeenStored() {
        Instrument instrument = aTradableInstrument();
        Key key = aRandomKey();
        repository.store(key, instrument);
        assertThat(repository.find(key)).contains(instrument);
    }

    @Test
    public void itShouldOverwriteEntriesForTheSameKey() {
        Instrument instrument1 = aTradableInstrument();
        Instrument instrument2 = aNonTradableInstrument();
        Key key = aRandomKey();
        repository.store(key, instrument1);
        repository.store(key, instrument2);
        assertThat(repository.find(key)).contains(instrument2);
    }

}