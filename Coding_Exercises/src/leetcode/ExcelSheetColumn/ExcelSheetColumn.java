package leetcode.ExcelSheetColumn;

public class ExcelSheetColumn {

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(n%26==0) {
                sb.append('Z');
                n--;
            }
            else
                sb.append((char)(n%26+64));
            n/=26;
        }
        return sb.reverse().toString();
    }



    public static void main(String[] args) {
        for (int i = 0; i < 550; i++) {
            System.out.println(convertToTitle(i));
        }
    }
}
