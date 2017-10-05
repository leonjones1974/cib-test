package uk.camsw.cib;

import java.util.Optional;

public interface MergeStrategy {

    static Optional<MergeStrategy> create(Instrument existing, InstrumentRefData newRefData) {
        return null;
    }

    Instrument merge(InstrumentRefData newRefData);

}
