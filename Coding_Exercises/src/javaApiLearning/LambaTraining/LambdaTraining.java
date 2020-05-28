package javaApiLearning.LambaTraining;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTraining {

    public static void main(String[] args) {

        // PIERWSZY SPOSÓB GENEROWANIA LICZB LOSOWYCH//
        Random random = new Random();

        Supplier<List>  getNumbers = () -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(random.nextInt(1000));
            }
            return list;
        };

        List<Integer> randomNumbers = getNumbers.get();

        // DRUGI SPOSÓB GENEROWANIA LICZB LOSOWYCH //

        List<Integer> randomNumbers2 = generate(10, () -> random.nextInt(1000));

        //WYPISYWANIE LISTY ZA POMOCĄ KONSUMERA//

        Consumer<Integer> consumer = x -> System.out.print(x + " ");

        for (Integer x: randomNumbers
             ) {
            consumer.accept(x);
        }

        System.out.println();

        // DRUGI SPOSÓB W WYDZIELONEJ METODZIE //
        consume(randomNumbers, x -> System.out.print(x + " "));

        //Usuwanie liczb nieparzystych z listy//

        System.out.println();

        filterList(randomNumbers, x -> x%2==0);

        consume(randomNumbers, x -> System.out.print(x + " "));




    }

    private static <T> List<T> generate(int toGenerate, Supplier<T> sup){
        List<T> generated = new ArrayList<>();
        for (int i = 0; i < toGenerate; i++) {
            generated.add(sup.get());
        }
        return generated;
    }

    private static <T> void consume(List<T> list, Consumer<T> consumer){
        for (T element: list
             ) {
            consumer.accept(element);
        }
    }

    private static <T> void filterList(List<T> list, Predicate<T> predicate){
        Iterator<T> iterator = list.listIterator();
        while (iterator.hasNext()){
            T element = iterator.next();
            if(predicate.test(element)){
                iterator.remove();
            }
        }
    }
    private static <T> void filterList2(List<T> list, Predicate<T> predicate){
        list.removeIf(predicate::test);
    }



}
