package designPatterns.creational.Factory_New;

import static designPatterns.creational.Factory_New.CarType.*;

public class App {
    public static void main(String[] args) {
        var ferrari = CarsFactory.createCar(FERRARI);
        var mustang = CarsFactory.createCar(MUSTANG);

        System.out.println(ferrari.getDescription());
    }
}
