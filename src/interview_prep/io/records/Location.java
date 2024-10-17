package interview_prep.io.records;

import java.io.Serializable;
import java.util.Objects;

public record Location(String city, String country) implements Serializable {
    public Location {
        Objects.requireNonNull(city);
        Objects.requireNonNull(country);
    }
}
