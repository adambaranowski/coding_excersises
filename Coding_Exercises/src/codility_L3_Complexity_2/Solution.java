package codility_L3_Complexity_2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int solution(Integer[] A) {
        // A[] = Integer.valueOf(A);

        /*
        List<Integer> numbers = Arrays.asList(A);
        Collections.sort(numbers);

/*
        int left = 0;
        int right = numbers.size() - 1;
        int center = (left + right) / 2;

        while (left <= right) {
            center = (left + right) / 2;
            if (right - left != numbers.get(right) - numbers.get(left)) {
                return center;
            }

            if (numbers.get(center) != numbers.get(right) - numbers.get(left)) {

                right = center - 1;
            } else {
                left = center + 1;
            }



        if (numbers.get(right + 1) - numbers.get(right) > 1) {
            return numbers.get(right);
        }

        if (numbers.get(left - 1) - numbers.get(left) > 1) {
            return numbers.get(left);
        }
        }


        return 0;*/

        int sum = ((A.length + 1) * ((A.length + 1) + 1)) / 2;
        //S=n*(a0 + an)/2 = n*(n+1)/2

        int real_sum = 0;
        for (int i = 0; i < A.length; i++) {
            real_sum += A[i];
        }

        return sum - real_sum;


    }

    public static void main(String[] args) {

        Integer[] A = {1, 2, 3, 4, 5, 6, 7, 9};
        System.out.print(solution(A));
    }
}
