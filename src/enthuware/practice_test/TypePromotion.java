package enthuware.practice_test;

public class TypePromotion {
}

class B {
    public int setVar(int a, int b, float c) {
        return 10;
    }
}
class C extends B {
    public int setVar(int a, float b, int c){
        return (int)(a + b + c);
    }
}

