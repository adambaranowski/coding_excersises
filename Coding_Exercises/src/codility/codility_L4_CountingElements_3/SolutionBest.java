package codility.codility_L4_CountingElements_3;
import java.util.*;
public class SolutionBest {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if(A[A.length-1]<=0){
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            if(A[i]>0){
                set.add(A[i]);
            }
        }

        for(int i = 1; i <= set.size(); i++){
            if(!set.contains(i)){
                return i;
            }
        }


        return A[A.length-1] + 1;


    }
}
