package enthuware.Lamda_FuncInterface;

import java.util.function.IntUnaryOperator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.List;

public class TestClass {
    public static int operate(IntUnaryOperator iuo) {
        return iuo.applyAsInt(5);
    }

    public static void main(String[] args) {
        /* IntFunction<IntUnaryOperator> fo = a-> b->a-b;  //1 */
        IntFunction<IntUnaryOperator> fo = a -> {
            return b -> {
                return a - b;
            };
        };
        int x = operate(fo.apply(20));
        System.out.println(x);

        IntUnaryOperator intOp = b -> b - 10;
        Predicate<Integer> p = q -> q > 2;
        List<Integer> list = List.of(1, 2, 3);
        printData(list, p);
        printData(list, (Integer q) -> { return q > 2; } );
        printData(list, (Integer q) -> q > 2 );
    }

    public static void printData(List<Integer> list, Predicate<Integer> p) {

    }
}