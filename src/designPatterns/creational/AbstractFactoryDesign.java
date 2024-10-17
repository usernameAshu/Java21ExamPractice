package designPatterns.creational;

public class AbstractFactoryDesign {
    public static void main(String[] args) {
        VehiclesFactory electricCarFactory = new ElectricCarFactory();
        VehiclesFactory electricShipFactory = new ElectricShipFactory();

        VehicleZ electricCar = electricCarFactory.createVehicle();
        VehicleZ electricShip = electricShipFactory.createVehicle();

        System.out.println(electricCar.getType());
        System.out.println(electricShip.getType());
    }
}

/*
Building on the same Factory design, now we have different variants of Car, Truck , Ships
It can be Electric Powered, Diesel Powered, Hydrogen powered
So, We need different factories who are capable to produce such variants
So, we need another layer of abstraction over the existing Factory pattern
 */

/* abstract Factory classes with its concrete Variant Factory to produce
concrete Variant Products
 */

abstract class VehiclesFactory {
   abstract VehicleZ createVehicle();
}
abstract class CarsFactory extends VehiclesFactory {}
abstract class TrucksFactory extends VehiclesFactory {}
abstract class ShipsFactory extends VehiclesFactory {}

class ElectricCarFactory extends CarsFactory {
    @Override
    VehicleZ createVehicle() {
        return new ElectricCar();
    }
}
class DieselCarFactory extends CarsFactory {
    @Override
    VehicleZ createVehicle() {
        return new DieselCar();
    }
}
class HydrogenCarFactory extends CarsFactory {
    @Override
    VehicleZ createVehicle() {
        return new HydrogenCar();
    }
}
class DieselTruckFactory extends TrucksFactory {
    @Override
    VehicleZ createVehicle() {
        return new DieselTruck();
    }
}
class ElectricShipFactory extends ShipsFactory {
    @Override
    VehicleZ createVehicle() {
        return new ElectricShip();
    }
}


/* Product interfaces with their concrete Variants */
interface VehicleZ {
    String getType();
}
abstract class CarZ implements VehicleZ {}
abstract class TruckZ implements VehicleZ {}
abstract class ShipZ implements VehicleZ {}

class ElectricCar extends CarZ {
    @Override
    public String getType() {
        return "Electric Car";
    }
}
class DieselCar extends CarZ {
    @Override
    public String getType() {
        return "Diesel Car";
    }
}
class HydrogenCar extends CarZ {
    @Override
    public String getType() {
        return "Hydrogen Car";
    }
}
class ElectricTruck extends TruckZ {
    @Override
    public String getType() {
        return "Electric truck";
    }
}
class DieselTruck extends TruckZ {
    @Override
    public String getType() {
        return "Diesel truck";
    }
}
class ElectricShip extends ShipZ {
    @Override
    public String getType() {
        return "Electric Ship";
    }
}