package interview_prep.CollectionsFramework;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        GenericList<Integer> list = new GenericList<>();

        list.addItem(1);
        list.addItem(2);
        list.addItem(3);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Size of list: "+ list.size());
    }
}
