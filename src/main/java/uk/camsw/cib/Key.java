package uk.camsw.cib;

public class Key {
    private final String value;

    public Key(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        return value != null ? value.equals(key.value) : key.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Key{" +
                "value='" + value + '\'' +
                '}';
    }
}
