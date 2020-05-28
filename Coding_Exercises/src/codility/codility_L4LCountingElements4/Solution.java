package codility.codility_L4LCountingElements4;

import java.util.Arrays;

public class Solution {

    public static int solution(int[] A){

        Arrays.sort(A);

        for(int i = 0; i < A.length; i++){
            if(i+1!=A[i])
                return 0;
        }


        return 1;
    }

    public static void main(String[] args) {

        int[] A = {4, 1, 3, 2};
        int[] B = {4, 1, 3};

        System.out.println(solution(A));
        System.out.println(solution(B));

    }
}
