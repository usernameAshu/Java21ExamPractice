package designPatterns.creational.Factory_New;

import java.util.function.Supplier;

public enum CarType {
    FERRARI(Ferrai::new),
    MUSTANG(Mustang::new);

    private Supplier<Car> car;

    private CarType(Supplier<Car> car) {
        this.car = car;
    }

    public Supplier<Car> getCarConstructor() {
        return car;
    }
}
