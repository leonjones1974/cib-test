package uk.camsw.cib;

import java.time.LocalDate;

public class LmeInstrumentRefData {
    private LocalDate lastTradingDate;

    public LmeInstrumentRefData(LocalDate lastTradingDate) {
        this.lastTradingDate = lastTradingDate;
    }
}
