package uk.camsw.cib;

import java.time.LocalDate;

public class Instrument {
    private final LocalDate lastTradingDate;
    private final LocalDate deliveryDate;
    private final Market market;
    private final String label;
    private final boolean tradable;

    public Instrument(LocalDate lastTradingDate, LocalDate deliveryDate, Market market, String label, boolean tradable) {
        this.lastTradingDate = lastTradingDate;
        this.deliveryDate = deliveryDate;
        this.market = market;
        this.label = label;
        this.tradable = tradable;
    }

    public LocalDate getLastTradingDate() {
        return lastTradingDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Market getMarket() {
        return market;
    }

    public String getLabel() {
        return label;
    }

    public boolean isTradable() {
        return tradable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instrument that = (Instrument) o;

        if (tradable != that.tradable) return false;
        if (lastTradingDate != null ? !lastTradingDate.equals(that.lastTradingDate) : that.lastTradingDate != null) return false;
        if (deliveryDate != null ? !deliveryDate.equals(that.deliveryDate) : that.deliveryDate != null) return false;
        if (market != null ? !market.equals(that.market) : that.market != null) return false;
        return label != null ? label.equals(that.label) : that.label == null;

    }

    @Override
    public int hashCode() {
        int result = lastTradingDate != null ? lastTradingDate.hashCode() : 0;
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        result = 31 * result + (market != null ? market.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (tradable ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "lastTradingDate=" + lastTradingDate +
                ", deliveryDate=" + deliveryDate +
                ", market=" + market +
                ", label='" + label + '\'' +
                ", tradable=" + tradable +
                '}';
    }
}
