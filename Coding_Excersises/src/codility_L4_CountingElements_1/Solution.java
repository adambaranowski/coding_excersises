package codility_L4_CountingElements_1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int solution(int X, int[] A){
        int earliestTime = Integer.MAX_VALUE;

        Set<Integer> leafes = new HashSet<>();

        for(int i = 0; i < A.length; i++){
            leafes.add(A[i]);
            if(leafes.size()==X){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};

        System.out.println(solution(X, A));
    }
}
