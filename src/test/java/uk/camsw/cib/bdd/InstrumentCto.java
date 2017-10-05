package uk.camsw.cib.bdd;

import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;
import uk.camsw.cib.Instrument;
import uk.camsw.cib.Market;

import java.time.LocalDate;

public class InstrumentCto {
    @XStreamConverter(LocalDateTransformer.class)
    public LocalDate lastTradingDate;
    @XStreamConverter(LocalDateTransformer.class)
    public LocalDate deliveryDate;
    @XStreamConverter(MarketTransformer.class)
    public Market market;
    public String label;
    public boolean tradable = true;

    public Instrument toInstrument() {
        return new Instrument(lastTradingDate, deliveryDate, market, label, tradable);
    }
}
