package codility_L4_CountingElements_2;
import java.util.*;
import java.lang.*;

public class Solution {
    public static int[] solution(int N, int[] A){
        List<Integer> counters = new ArrayList<>();

        for(int i = 0; i < N; i++){
            counters.add(0);
        }

        

        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;
        System.out.println(solution(N, A));
    }
}
