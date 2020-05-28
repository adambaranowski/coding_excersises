package codility.codility_L2_Arrays_1;

/*

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the
above conditions, returns the value of the unpaired element.

 */

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int solution(int[] A){
        int number;
        int finall_number = -1;

        Set<Integer> checked_numbers = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {

            if(!checked_numbers.contains(A[i])){
                checked_numbers.add(A[i]);
                number = A[i];

                for(int z = 0; z < A.length; z++){
                    if(z!=i){
                        if(A[i]==A[z]){
                            number = -1;
                            break;
                        }
                    }

                }
                if(number!=-1){

                    return number;
                }



            }
        }

        //System.out.println(checked_numbers.toString());

        return finall_number;
    }

    public static void main(String[] args) {

        int[] A = {1, 1, 2, 8,3, 5, 5, 6,8, 9,2, 3, 9, 6,7,7,19}; //2

        System.out.println(solution(A));
    }

}
