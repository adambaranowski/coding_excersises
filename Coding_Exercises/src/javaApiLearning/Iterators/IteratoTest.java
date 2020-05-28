package javaApiLearning.Iterators;

import java.util.*;

public class IteratoTest {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("adam");
        names.add("puciak");
        names.add("piotr");
        names.add("goldus");

        System.out.println(names);

        Iterator<String> iterator = names.iterator();

//        for (String name: names
//        ) {
//            if(name.equals("piotr"))
//            {}
//        }

        while (iterator.hasNext()){
            if(iterator.next().equals("piotr"))

                iterator.remove();
        }
        System.out.println(names);

        ListIterator<String> stringListIterator = names.listIterator();

        while (stringListIterator.hasNext()){
            String element = stringListIterator.next();
            if(element.equals("puciak"))
                stringListIterator.set(element + "+");
        }
        System.out.println(names);

        LinkedHashMap<String, String> cities = new LinkedHashMap<>();

    }
}
