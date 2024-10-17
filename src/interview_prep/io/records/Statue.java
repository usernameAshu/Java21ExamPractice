package interview_prep.io.records;

import java.io.Serializable;
import java.util.Objects;

public record Statue(String name, int height, Location location) implements Serializable {
    public Statue {
        Objects.requireNonNull(name);
        Objects.requireNonNull(location);
        if(height < 0)
            throw new IllegalArgumentException("Height cannot be negative");
    }
}
