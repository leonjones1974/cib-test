package uk.camsw.cib.bdd;

import uk.camsw.cib.Instrument;
import uk.camsw.cib.Key;
import uk.camsw.cib.Market;

import java.time.LocalDate;
import java.util.UUID;

public class DataSupport {

    public static Instrument aTradableInstrument() {
        return anInstrument(true);
    }

    public static Instrument aNonTradableInstrument() {
        return anInstrument(false);
    }

    private static Instrument anInstrument(boolean tradable) {
        return new Instrument(LocalDate.now(), LocalDate.now().plusDays(1), new Market("a_market"), "a_label", tradable);
    }


    public static Key aRandomKey() {
        return new Key(UUID.randomUUID().toString());
    }
}
