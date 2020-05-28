package javaApiLearning.SingletonExercise;

import java.util.ArrayList;
import java.util.List;

public class NumberService {



    List<Integer> numbers = new ArrayList<>();

    //WERSJA ZAJMUJĄCA PAMIĘĆ OD RAZU
//    private NumberService() {
//    }
//
//    private static NumberService instance = new NumberService();
//
//    public static NumberService getInstance(){
//        return instance;
//    }

    //WERSJA ULEPSZONA
    private NumberService(){

    }

    private static NumberService instance = null;

    public static NumberService getInstance(){
        if(instance==null){
            instance = new NumberService();
        }
        return instance;
    }


    public void addNumber(Integer number) {
        numbers.add(number);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}
