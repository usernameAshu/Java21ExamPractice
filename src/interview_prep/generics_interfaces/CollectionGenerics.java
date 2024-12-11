package interview_prep.generics_interfaces;

import java.util.List;
import java.util.ArrayList;

public class CollectionGenerics {
}


class Base {
    public <T> List<T> processList(List<T> list) {
        System.out.println("In Base class");
        return null;
    }
}

class Sub extends Base {
    @Override   /* valid*/
    public <T> List<T> processList(List<T> list) {
        return null;
    }

    /* invalid overload because both methods have same erasure*/
    /*public List<String> processList(List<String> list) {
        return null;
    }*/
}
