package leetcode.RomanToInteger;

import java.util.ArrayList;
import java.util.List;

public class RomanToIntegerBetter {

    public static int romanToInt(String s) {
        List<Integer> stringInNumbers = new ArrayList<>();
        for (char c : s.toCharArray()
        ) {
            switch (c) {
                case ('I'):
                    stringInNumbers.add(1);
                    break;
                case ('V'):
                    stringInNumbers.add(5);
                    break;
                case ('X'):
                    stringInNumbers.add(10);
                    break;
                case ('L'):
                    stringInNumbers.add(50);
                    break;
                case ('C'):
                    stringInNumbers.add(100);
                    break;
                case ('D'):
                    stringInNumbers.add(500);
                    break;
                case ('M'):
                    stringInNumbers.add(1000);
                    break;
            }
        }

        int result = 0;
        for (int i = 0; i < stringInNumbers.size(); i++) {

            if (i + 1 < stringInNumbers.size()) {
                if (stringInNumbers.get(i) < stringInNumbers.get(i + 1)) {
                    result -= stringInNumbers.get(i);
                } else {
                    result += stringInNumbers.get(i);
                }
            } else {
                result += stringInNumbers.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
