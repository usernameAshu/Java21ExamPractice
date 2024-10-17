package designPatterns.creational;

public class FactoryDesign {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();
        Vehicle car = carFactory.createVehicle();
        Vehicle truck = truckFactory.createVehicle();

        System.out.println(car.getType());
        System.out.println(truck.getType());
    }
}

/*
We have a Vehicle ecosystem,
where we need to produce different types of vehicle like Car, Truck, Ships
So, we need a factory to produce this different types of vehicles
It takes care of Single Responsibility Principal and Open-Closed Principal from SOLID
 */

/* Factory interface and concrete factories */
abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}
class CarFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
class ShipFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Ship();
    }
}
class TruckFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Truck();
    }
}

/* Product interface and Concrete products */
interface Vehicle {
    String getType();
}
class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}
class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}
class Ship implements Vehicle {
    @Override
    public String getType() {
        return "Ship";
    }
}