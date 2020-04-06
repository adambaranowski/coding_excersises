package BST_RandomTest;

import java.util.Random;

public class RandomTest {

    public double countFactor(){
        int primes = 0;
        int otthers = 0;

        double num1;
        double num2;

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            num1 = random.nextInt(1000_000);
            num2 = random.nextInt(1000_000);

            if(relativelyPrime((int)num1, (int)num2)){
                primes++;
            }else{
                otthers++;
            }

        }

        //System.out.println(primes);
        //System.out.println(otthers);

        double wyn = (double) primes/(double) (primes+otthers);


        return wyn;
    }

    private int gcd(int a, int b) {
        int t;
        while(b != 0){
            t = a;
            a = b;
            b = t%b;
        }
        return a;
    }

    private boolean relativelyPrime(int a, int b) {
        return gcd(a,b) == 1;
    }





    public static void main(String[] args) {

        double rightFactor = 6/Math.pow(Math.PI,2);

        RandomTest randomTest = new RandomTest();

//
//
//        System.out.println(rightFactor);
//        System.out.println(randomTest.countFactor());
//
//        System.out.println();

        System.out.println("Right Pi: "+Math.PI);
        System.out.println("Pi from Random: "+ Math.sqrt(6.0/randomTest.countFactor()));

    }
}
