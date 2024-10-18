package interview_prep;

//create a sealed class
public sealed class SealedClass permits SubSealedClass {
    //create a method
    public void m1() {
        System.out.println("SealedClass.m1");
    }
}

//create a sub sealed class
final class SubSealedClass extends SealedClass {
    //create a method
    public void m1() {
        System.out.println("SubSealedClass.m1");
    }
}

class Test {
    public static void main(String[] args) {
        SealedClass sealedClass = new SubSealedClass();
        sealedClass.m1();
    }
}
/*
Sealed classes permits the mentioned class only to inherit them.
Other classes are prohibited to extend them

The sealed keyword in Java is used to restrict which classes or interfaces can extend or implement a given class or interface.
This feature was introduced in Java 15 as a preview feature and became a standard feature in Java 17.

A sealed class or interface restricts which other classes or interfaces may extend or implement it.
The permitted subclasses or implementations must be explicitly specified using the permits clause.
The subclasses can be final, sealed, or non-sealed.

Example:
// Sealed class
public sealed class Vehicle permits Car, Truck {
    // Class content
}

// Permitted subclass
public final class Car extends Vehicle {
    // Class content
}

// Another permitted subclass
public non-sealed class Truck extends Vehicle {
    // Class content
}
 */