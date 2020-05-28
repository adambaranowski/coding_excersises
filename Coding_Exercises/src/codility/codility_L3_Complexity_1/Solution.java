package codility.codility_L3_Complexity_1;

public class Solution {
    public static int solution(int X, int Y, int D) {
        int number = 0;

        int division = (Y - X) / D;
        if (division > 1) {
            number += division;
            X += division;
        }


        while (X < Y) {
            X += D;
            number++;
        }

        return number;
    }

    public static void main(String[] args) {
        System.out.print(solution(10, 100000000, 1));
    }
}
