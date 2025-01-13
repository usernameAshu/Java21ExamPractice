package enthuware.Concurency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        // Create a HashMap and populate it with some data
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        // Get the entries and sort them in reverse order based on values
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print the map entries in reverse value order
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }

    public void getLocks(Object a, Object b)
    {
        synchronized(a)
        {
            synchronized(b)
            {
                //do something
            }
        }
    }
}
