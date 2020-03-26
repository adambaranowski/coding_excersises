package codility_L5_PrefixSums_2;

public class Solution {

    public static int[] solution(String S, int[] P, int[] Q){
        int solution[] = new int[P.length];
        int p;
        int q;
        int pmin = P.length;
        int qmax = 0;

        int min;

        for (int i = 0; i < P.length; i++) {

            min = 4;
            if(P[i]>=pmin&&Q[i]<=qmax){
                solution[i] = solution[i-1];
                continue;
            }
            p=P[i];
            q=Q[i];

            if(P[i]>=pmin&&Q[i]>=qmax){
                pmin = p;
                qmax = q;
            }




            for (Character s: S.substring(p,q+1).toCharArray()
                 ) {
                if(min == 1){
                    break;
                }else if (s == 'T' && min ==4){
                    min = 4;
                }else if(s == 'G'&&min>3){
                    min = 3;
                }else if(s == 'C'&& min > 2){
                    min = 2;
                }else if(s == 'A' && min > 1){
                    min = 1;
                }


            }
            solution[i]=min;

        }

        return solution;
    }

    public static void main(String[] args) {
        int[] P = {2 ,5 ,0,6,0};
        int[] Q = {4, 5, 6,6,0};
        String S = "CAGCCTA";

        for (int i: solution(S, P, Q)
             ) {
            System.out.println(i);

        }

        String a = "puciak";
        System.out.println(S.substring(6,7));
        System.out.println(a.substring(0,2));
    }
}
