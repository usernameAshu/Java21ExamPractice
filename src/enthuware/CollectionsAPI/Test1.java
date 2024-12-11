package enthuware.CollectionsAPI;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SequencedCollection;

public class Test1 {
    public static void main(String[] args) {
        var arr = new Integer[]{1,2,3,4};
        var list1 = List.of(arr); /* List.of(...) will throw a Null Pointer Exception, as List.of(..) doesn't allow Null Values */
        var list2 = Collections.unmodifiableList(list1);
        arr[0] = 10;

        System.out.println(list1+ "  " + list2);

        //q7
        SequencedCollection<String> str = new ArrayList<>();
        str.addFirst("a");
        str.add(null);
        str.add("b");
        str.remove(null);
        System.out.println(str);

    }
}
