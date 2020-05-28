package codility.codility_L4_CountingElements_3;

import java.util.*;

public class Solution {
    public static int solution(Integer[] A){
        int min = 1;



        List<Integer> aInList = new ArrayList<Integer>(Arrays.asList(A));

        for (int i = 1; i<aInList.size(); i++){
            if(!aInList.contains(i)){
                return i;
            }
        }

        Set<Integer> set = new HashSet<         >();

        return min;
    }

    public static void main(String[] args) {
        Integer[] A = {1, 3, 6, 1, 2};
        System.out.println(solution(A));
    }
}
