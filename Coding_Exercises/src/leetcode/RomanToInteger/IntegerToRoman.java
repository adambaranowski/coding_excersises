package leetcode.RomanToInteger;

public class IntegerToRoman {
    public static String intToRoman(int x){
        String[] UNITS = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] TENTS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] HUNDREDS= {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] THOUSANDS= {"", "M", "MM", "MMM"};

        return THOUSANDS[x/1000]+HUNDREDS[(x%1000)/100]+TENTS[(x%100)/10]+UNITS[(x%10)];
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
    }
}
