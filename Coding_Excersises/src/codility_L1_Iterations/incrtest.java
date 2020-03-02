package codility_L1_Iterations;

public class incrtest {
    public static void main(String[] args) {

        int a = 0, b = 13, c = 0;

        a = ++b * 2;

        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.print(c + " ");
        System.out.println();

        c = a++ + b;

        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.print(c + " ");
        System.out.println();

        b = ++a + a-- - c++ - --c;


        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.print(c + " ");
        System.out.println();

        System.out.println("a=" + a + ", b=" + b + ", c=" + c);
    }
}
