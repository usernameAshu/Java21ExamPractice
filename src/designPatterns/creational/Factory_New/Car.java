package designPatterns.creational.Factory_New;

public interface Car {
    String getDescription();
}

class Ferrai implements Car {
    public String getDescription() {
        return "Ferrari";
    }
}

class Mustang implements Car {
    public String getDescription() {
        return "Mustang";
    }
}
