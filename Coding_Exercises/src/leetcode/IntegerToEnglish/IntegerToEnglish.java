package leetcode.IntegerToEnglish;

public class IntegerToEnglish {

    public static String numberToWords(int number) {
        if(number==0){
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();

        //divide by three because subnumber always need three digits of number

        int magnitudeScaler = ((int) Math.log10(number) / 3);
        int x;
        if((x=4)>0)

        if (magnitudeScaler == 3) {
            String s;
            if(!(s = subNumber(number, 3 * magnitudeScaler)).equals("")) {
                sb.append(" ");
                sb.append(s);
                sb.append(" Billion");
            }
            number = number % 1000_000_000;
            magnitudeScaler--;
        }
        if (magnitudeScaler == 2) {
            String s;
            if(!(s = subNumber(number, 3 * magnitudeScaler)).equals("")) {
                sb.append(" ");
                sb.append(s);
                sb.append(" Million");
            }
            number = number % 1000_000;
            magnitudeScaler--;
        }
        if (magnitudeScaler == 1) {

            //sb.append(subNumber(number, 3 * magnitudeScaler));

            String s;
            if(!(s = subNumber(number, 3 * magnitudeScaler)).equals("")) {
                sb.append(" ");
                sb.append(s);
                sb.append(" Thousand");
            }

            number = number % 1000;
            magnitudeScaler--;
        }
        if (magnitudeScaler == 0) {
            String s;
            if(!(s = subNumber(number, 3 * magnitudeScaler)).equals("")) {
                sb.append(" ");
                sb.append(s);
            }
        }

        return sb.toString().trim();
    }

    public static String subNumber(int number, int magnitude) {

        String[] UNITS = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
        String[] TEENS = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String[] TENS = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

        StringBuilder sb = new StringBuilder();

        int hundred = (int)((long)number / (long) Math.pow(10, magnitude + 2));
        int tens = (int)((number % (long) Math.pow(10, magnitude + 2)) / (long) Math.pow(10, magnitude + 1));
        int units = (int)((number % (long) Math.pow(10, magnitude + 1)) / (long) Math.pow(10, magnitude));

        sb.append(UNITS[(int)hundred]);

        if (hundred > 0)
            sb.append(" Hundred");
        if (tens == 1) {
            sb.append(TEENS[units]);
        } else {
            sb.append(TENS[tens]);
            sb.append(UNITS[units]);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(2_147_483_647));
    }
}
