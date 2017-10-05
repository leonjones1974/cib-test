package uk.camsw.cib;

import org.assertj.core.util.Lists;

import java.util.List;

public class TestPublisher implements InstrumentPublisher {

    public List<Instrument> published = Lists.emptyList();

    @Override
    public void publish(Instrument instrument) {

    }
}
