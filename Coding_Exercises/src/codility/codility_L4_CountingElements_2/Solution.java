package codility.codility_L4_CountingElements_2;
import java.util.*;
import java.lang.*;

public class Solution {

    public static int[] counters;

    public static int[] solution(int N, int[] A){

        counters = new int[N];
        for(int i = 0; i < N; i++){
            counters[i] = 0;
        }
        int max = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]>=1&&A[i]<=N){
                increase(A[i]);
                if(counters[A[i]-1]>max){
                    max++;
                }

            }
            if(A[i]==N+1){
                maxCounter(max);
            }
            for(int j = 0; j < counters.length; j++){
                System.out.print(counters[j]);

            }
            System.out.print(" " + max);
            System.out.println();
        }



        return counters;
    }
    public static void increase(int X){
        counters[X-1] = counters[X-1] + 1;
    }

    public static void maxCounter(int max){
        //int max = Integer.MIN_VALUE;
       // for(int i = 0; i < counters.length; i++){
       //     if(counters[i]>max){
        //        max = counters[i];
        //}
        Arrays.fill(counters, max);
        //for (int i = 0; i < counters.length; i++){
          //  counters[i] = max;
        //}
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;

        int[] s = solution(N, A);

        for(int i = 0; i < 5; i++){
            System.out.print(s[i]);
        }

    }
}
