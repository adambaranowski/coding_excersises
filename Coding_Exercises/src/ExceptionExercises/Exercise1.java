package ExceptionExercises;

public class Exercise1 {
    public static int[] table = {1, 5, 4, 2, 9, 10, 24, 23};

    public static void main(String[] args) {
        try {
            for (int i = 0; i < table.length + 1; i++
            ) {
                System.out.println(table[i]);

            }
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
