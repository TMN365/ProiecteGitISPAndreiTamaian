package Exercise3.safehome;

import java.util.Objects;

/**
 * Name of a tenant.
 */
public class Tenant {
    private String name;

    public Tenant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant that = (Tenant) o;
        return that.name == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
