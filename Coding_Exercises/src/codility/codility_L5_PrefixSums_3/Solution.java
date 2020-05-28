package codility.codility_L5_PrefixSums_3;

public class Solution {
    public static int solution(int[] A){
        int wyn = 0;

        return wyn;
    }

    public static void main(String[] args) {

        char x = 'x';
        String s = "123";
        Integer a = Integer.parseInt(s);
        int b = Integer.valueOf(s);

        System.out.println((int)x);
        System.out.println(Integer.compare(2, 2));

        long p = 65537L;
        long q = 65539L;

        long pq = p*q;

        System.out.println(pq);

        for (long i = 2L; i < pq; i++) {
            if(pq%i==0){
                System.out.print(i + " ");
            }


        }

    }
}
