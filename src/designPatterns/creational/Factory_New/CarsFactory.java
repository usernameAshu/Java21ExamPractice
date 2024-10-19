package designPatterns.creational.Factory_New;

public class CarsFactory {

    public static Car createCar(CarType type) {
        return type.getCarConstructor().get();
    }
}
