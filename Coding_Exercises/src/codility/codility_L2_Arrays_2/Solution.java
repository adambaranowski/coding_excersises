package codility.codility_L2_Arrays_2;

public class Solution {
    public static int[] solution(int[] A, int K) {
        int[] cycled = new int[A.length];

        if (A.length == 0) {
            return A;
        }

        int position = K;

        //if(position>(A.length-1)){
        position = position % A.length;
        //}

        for (int i = 0; i < A.length; i++) {

            if (position > (A.length - 1)) {
                position = 0;
            }
            cycled[position] = A[i];
            position++;
        }

        return cycled;

    }

    public static void main(String[] args) {
        int[] test_array = {1, 2, 3, 4, 5, 5, 6, 7, 8, 4, 3, 2, 7, 1, 2, 3};
        int test_step = 14298;
        for (int a : solution(test_array, test_step)
        ) {
            System.out.print(" " + a);

        }
    }
}
