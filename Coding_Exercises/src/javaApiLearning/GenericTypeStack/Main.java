package javaApiLearning.GenericTypeStack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();

//        numbers.add(1);
//        numbers.add(2);

        for (int i = 1; i <= 2000_000; i++) {
            numbers.add(i);
        }

        for (int i = 100_000; i >=0 ; i--) {
            System.out.print(numbers.pop() + " ");
            if(i%35==0){
                System.out.println();
            }
        }
    }
}
