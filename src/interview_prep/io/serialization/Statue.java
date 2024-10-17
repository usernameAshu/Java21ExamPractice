package interview_prep.io.serialization;

import java.io.Serializable;
import java.util.Objects;

public class Statue implements Serializable {
    private String name;
    private int height;
    private Location location;

    public Statue(String name, int height, Location location) {
        Objects.nonNull(name);
        Objects.nonNull(location);
        if(height < 0)
            throw new IllegalArgumentException("Height cannot be negative");

        this.name = name;
        this.height = height;
        this.location = location;
    }

    //getter setter equals omitted

    @Override
    public String toString() {
        return "Statue{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", location=" + location +
                '}';
    }
}

class Location implements Serializable {
    private String city;
    private String country;

    public Location(String city, String country) {
        Objects.nonNull(city);
        Objects.nonNull(country);
        this.city = city;
        this.country = country;
    }

    //getter setter equals omitted

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
