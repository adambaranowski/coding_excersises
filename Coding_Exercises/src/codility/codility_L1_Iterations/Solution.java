package codility.codility_L1_Iterations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
THIS PROGRAM HAS THE FOLLOWING METHODS:
    solution(int N) - which returns the maximum length of gap
        that contains only zeros in binary representation of decimal N

    toBin(int N) - returns binary representation of N

    toHex(int N) - returns hexadecimal representation of number

    toAnySyst(int N, int system) - representation on decimal N in the system
        with the base od variable "system"


 */

public class Solution {



    public static void main(String[] args) {

        int N = 5;

        for (int bit: toBin(N)
        ) {
            System.out.print(bit);

        }

        System.out.println();

        for (String bit: toHex(N)
        ) {
            System.out.print(bit);

        }
        System.out.println();

        for (String ss: toAnySyst(N, 16)
        ) {
            System.out.print(ss);

        }
        System.out.println();

        System.out.println(solution(N));

    }


    public static int solution(int N){

        List<String> number = toAnySyst(N, 2);

        int max = 0;
        int remembered_max = 0;
        int curent = 0;

        for(int i = 0; i < number.size(); i++){
            if(number.get(i).equals("0")){
                curent+=1;
            }else {
                remembered_max = max;
                curent = 0;
            }

            if(curent>max){
                max = curent;
            }

        }

        return remembered_max;
    }


    public static List<String> toAnySyst(int N, int system){
        List<String> conwertedN = new ArrayList<>();

        while (Double.valueOf(N)/system>0){
            conwertedN.add(Case(N%system));
            N=N/system;
        }
        Collections.reverse(conwertedN);
        return conwertedN;
    }

    public static String Case(int N){
        String s = null;

        if(N<10){
            s = String.valueOf(N);
        }else{
            char c = (char)(N+55);
            s = String.valueOf(c);
        }

        return s;
    }






    public static List<Integer> toBin(int N){
        List<Integer> binaryN = new ArrayList<Integer>();


        while(N>0){

            if(N%2==0){
                binaryN.add(0);
            }else{
                binaryN.add(1);
            }
            N = N / 2;
        }

        Collections.reverse(binaryN);
        return binaryN;
    }

    public static List<String> toHex(int N){
        List<String> hexN = new ArrayList<>();

        while(Double.valueOf(N)/16>0){
            //if(Double.valueOf(N)/16>0&&Double.valueOf(N)/16<1){
            //    hexN.add(String.valueOf(N%16));
            //}
            switch (N%16){
                case 0:
                    hexN.add("0");
                    break;
                case 1:
                    hexN.add("1");
                    break;
                case 2:
                    hexN.add("2");
                    break;
                case 3:
                    hexN.add("3");
                    break;
                case 4:
                    hexN.add("4");
                    break;
                case 5:
                    hexN.add("5");
                    break;
                case 6:
                    hexN.add("6");
                    break;
                case 7:
                    hexN.add("7");
                    break;
                case 8:
                    hexN.add("8");
                    break;
                case 9:
                    hexN.add("9");
                    break;
                case 10:
                    hexN.add("A");
                    break;
                case 11:
                    hexN.add("B");
                    break;
                case 12:
                    hexN.add("C");
                    break;
                case 13:
                    hexN.add("D");
                    break;
                case 14:
                    hexN.add("E");
                    break;
                case 15:
                    hexN.add("F");
                    break;
            }
            N=N/16;

        }

        Collections.reverse(hexN);
        return hexN;
    }

}
