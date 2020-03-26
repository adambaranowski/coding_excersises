package SingletonExercise;

public class Main {
    public static void main(String[] args) {
        NumberService numberService = NumberService.getInstance();
        numberService.addNumber(1);
        numberService.addNumber(5);
        System.out.println(numberService.getNumbers());
    }

}
