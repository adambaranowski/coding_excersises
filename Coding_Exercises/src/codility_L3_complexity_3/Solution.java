package codility_L3_complexity_3;

import java.util.*;
import java.lang.*;

public class Solution {
    public static int Solution(int[] A){

        if(A.length == 0){
            return 0;
        }

        int total = 0;
        for(int i = 0; i < A.length; i++){
            total +=  A[i];

        }

        int wyn = Integer.MAX_VALUE;
        int sum = 0;



        for(int i = 0; i < A.length-1 ; i++){
            sum += A[i];
            if(Math.abs(total - sum - sum)<wyn){
                wyn = total - sum - sum;
            }
        }


        return wyn;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4, 3};
        int[] b = {};
        int[] c = {13, 15, 16, 20};
        int[] d = {20, 21, 50};

        System.out.println(Solution(a ));
        System.out.println(Solution(b ));
        System.out.println(Solution(c ));
        System.out.println(Solution(d ));

    }
}
