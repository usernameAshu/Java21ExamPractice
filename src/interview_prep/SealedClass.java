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