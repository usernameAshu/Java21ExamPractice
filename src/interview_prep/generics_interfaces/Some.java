package interview_prep.generics_interfaces;

/*
T -> type
V -> value
K -> key
 */
public class Some<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
