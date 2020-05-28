package javaApiLearning.CollectionsWithStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader("text.txt"))){

            String tmp = null;
            while ((tmp = bufferedReader.readLine())!=null){
                words.addAll(Arrays.asList(tmp.split(" ")));
            }
        }catch (IOException e){ e.printStackTrace();
        }

        words = words.stream()
                .map(s -> s.replaceAll("\\.", "").replaceAll(",", ""))
                .collect(Collectors.toCollection(ArrayList::new));

        long wordWithS=
                words.stream()
                .filter(x -> x.startsWith("s"))
                        //.peek(System.out::println)
                .count();


        long wordWithLength5 = words.stream()
                .filter(s -> s.length()==5)
                .count();


        words.stream().forEach(System.out::println);
        System.out.println(wordWithS);
        System.out.println(wordWithLength5);

    }
}
