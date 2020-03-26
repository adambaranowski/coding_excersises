package codility_L5_PrefixSums_1;

public class Solution {

    public static int solution(int A, int B, int K){

        int first = K;

        for(int i = A; i <= B ; i++){
            if(i%K==0){
                first = i;
                break;

            }
        }



        return B/K - first/K + 1;
    }

    public static void main(String[] args) {

        System.out.println(solution(8,13,7));

    }
}
