package leetcode.RomanToInteger;

import java.util.HashMap;

public class RomanToInteger {

    public static HashMap<String, Integer> values = new HashMap<>();


    public static int romanToInt(String s) {
        {
            values.put("I", 1);
            values.put("V", 5);
            values.put("X", 10);
            values.put("L", 50);
            values.put("C", 100);
            values.put("D", 500);
            values.put("M", 1000);
        }

        int finalResult = 0;

        int[] set3 = {0, 0, 0};
        int setIndex = 0;

        //CASE ONE NUMBER WITH DIFFERENTATION
        if (s.length() == 2) {
            if (twoChars(s.substring(0, 2)) > 0) {
                return twoChars(s.substring(0, 2));
            }
        }
        set3[setIndex] = values.get(s.substring(0, 1));
        setIndex++;

        int numberWithMinus;

        for (int i = 1; i < s.length(); i++) {
            numberWithMinus = twoChars(s.substring(i - 1, i + 1));


            if (numberWithMinus > 0) {
                finalResult += numberWithMinus;
                set3[0] = 0;
                set3[1] = 0;
                set3[2] = 0;
                setIndex = 0;
            } else {

                if (values.get(s.substring(i, i + 1)) == set3[setIndex]) {
                    setIndex++;
                    set3[setIndex] = values.get(s.substring(i, i + 1));
                } else {

                    if (setIndex > 0 && values.get(s.substring(i, i + 1)) > set3[setIndex - 1]) {

                        finalResult += (values.get(s.substring(i, i + 1)) - set3[setIndex - 1]);

                        set3[setIndex - 1] = 0;
                        setIndex = 0;
                    } else {

                        for (int j = 0; j <= setIndex; j++) {
                            finalResult += set3[j];
                            set3[j] = 0;
                        }

                        for (int j = 0; j <= setIndex; j++) {
                            finalResult += set3[j];
                            set3[j] = 0;
                        }
                        setIndex = 0;
                        set3[setIndex] = values.get(s.substring(i, i + 1));

                    }
                }
            }
        }

        for (int j = 0; j <= setIndex; j++) {
            finalResult += set3[j];
            set3[j] = 0;
        }

        return finalResult;
    }

    public static int twoChars(String s) {
        if (values.get(s.substring(0, 1)) < values.get(s.substring(1, 2))) {
            return values.get(s.substring(1, 2)) - values.get(s.substring(0, 1));
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LIX"));
    }
}
