package uk.camsw.cib;

public class Market {
    private final String value;

    public Market(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Market market = (Market) o;

        return value != null ? value.equals(market.value) : market.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Market{" +
                "value='" + value + '\'' +
                '}';
    }
}
