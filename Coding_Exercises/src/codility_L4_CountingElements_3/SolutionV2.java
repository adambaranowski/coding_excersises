package codility_L4_CountingElements_3;

import java.util.Arrays;

public class SolutionV2 {
    public static int solution(int[] A) {
        // write your code in Java SE 8


        int holder = 1;
        Arrays.sort(A);
        if (A[A.length - 1] < 1) {
            return holder;
        }

        int lastNumber=-1;
        for (int i = 1; i < A.length-1; i++) {
            if (A[i] > 0) {

                    if (A[i] != holder) {
                        return holder;
                    }
                   // if(A[i]!=lastNumber){
                        holder++;
                    //}

                    lastNumber=A[i];

            }

        }

        return A[A.length - 1] + 1;
    }

    public static void main(String[] args) {
        int[] A = {3,6,4,1,2};
        System.out.println(solution(A));
    }
}
