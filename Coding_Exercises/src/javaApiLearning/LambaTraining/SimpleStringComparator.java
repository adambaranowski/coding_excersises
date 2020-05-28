package javaApiLearning.LambaTraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleStringComparator {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Karol");
        names.add("Piotr");
        names.add("Marek");

        Collections.sort(names, String::compareToIgnoreCase);

        System.out.println(names);
    }
}
