package Exercise3.safehome;

import java.util.Objects;

/**
 * Code to open a door.
 */
public class AccessKey {
    private String pin;

    public AccessKey(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessKey that = (AccessKey) o;
        return that.pin == this.pin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin);
    }

}
