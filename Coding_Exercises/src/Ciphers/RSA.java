package Ciphers;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class RSA {
    /*
    kroki algorytmu:
        -znajdujemy liczby pierwsze p i q (np p=7 i q=13)
        -obliczamy n = p*q (n = 7*13=91)
        -wybieramy liczbe pierwszą e (wykładnik) mniejszą od (p-1)(q-1)
         np e=5
         +klucz publiczny to e oraz n (e=5 i n=91)

         -obliczamy element odwrotny d względem liczby e mod (p-1)(q-1)
            czyli d powinno być taką liczbą, że e*d mod(p-1)(q-1) = 1
           (tutaj d=29 bo 5*29mod72=145mod72=1)
         +klucz prywatny to d=29 oraz n=91

         Szyfrowanie:
         Mamy wiadomość M. (M=48)
         Szyfrogram C=M^e mod n (C=48^5mod91 = 254803968mod91=55)

         Deszyfrowanie:
         C=55
         M=C^d mod n (M = 55^29 mod 91 = 48)

     */

    private long p;
    private long q;

    public BigInteger pq;
    public BigInteger p1q1;

    public BigInteger e;
    public BigInteger d;

    public RSA(long p, long q) {
        this.p = p;
        this.q = q;
        pq=  new BigInteger(String.valueOf(p * q));
        p1q1=new BigInteger(String.valueOf((p-1)*(q-1)));
    }

    public RSA(){
        p=7;
        q=13;
        pq= new BigInteger(String.valueOf(p * q));
        p1q1= new BigInteger(String.valueOf((p-1)*(q-1)));
        e= new BigInteger(String.valueOf(5));
        d= new BigInteger(String.valueOf(inverse(e,p1q1)));
    }

    public BigInteger cipher(BigInteger message){


        return new BigInteger(String.valueOf(message.pow(e.intValue()).mod(pq)));
    }

    public BigInteger message(BigInteger cipher){

        return new BigInteger(String.valueOf(cipher.pow(e.intValue()).mod(pq)));

    }



    //liczby pierwsze z zakresu od n do m
    public List primes(long n, long m){
        List<Long> p = new ArrayList<>();
        boolean isPrime = false;
        for (long i = n; i <= m; i++) {
            isPrime=true;
            for (long j = 2; j < i; j++) {
                if(i%j==0){
                    isPrime=false;
                }
            }
            if(isPrime){
                p.add(i);
            }
        }

        return p;
    }

    public List keys(long p, long q){
        List<BigInteger> k = new ArrayList();

        BigInteger pp = new BigInteger(String.valueOf(primes(p,q).get(0)));
        BigInteger qq = new BigInteger(String.valueOf(primes(p,q).get(primes(p,q).size()-1)));
        BigInteger pq = pp.multiply(qq);
        BigInteger p1q1 = pp.add(new BigInteger("-1")).multiply(qq.add(new BigInteger("-1")));
        BigInteger e = new BigInteger("17");//new BigInteger(String.valueOf(primes(p,q).get(2)));
        BigInteger d = new BigInteger(String.valueOf(inverse(e,p1q1)));

        this.p = Long.parseLong(pp.toString());
        this.q = Long.parseLong(qq.toString());
        this.pq = pq;
        this.p1q1 = p1q1;
        this.e = e;
        this.d = d;

        k.add(pp);
        k.add(qq);
        k.add(pq);
        k.add(p1q1);
        k.add(e);
        k.add(d);


        return k;
    }



    //naiwne znajdywanie elementu odwrotnego
    public BigInteger inverse(BigInteger e, BigInteger modulator){

        BigInteger one = new BigInteger("1");

        for (BigInteger i = new BigInteger("1"); (modulator.compareTo(i))>0; i=i.add(one)) {
            if((e.multiply(i)).mod(modulator).compareTo(one)==0){

                return i;

            }
        }
        return one;
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();

//        for (Object i: rsa.primes(199900, 200000)
//            ) {
//           System.out.println(i);
//        }

        System.out.println(rsa.cipher(new BigInteger("48")));

        //System.out.println(rsa.d);
        //System.out.println(rsa.e);

        System.out.println(rsa.message(rsa.cipher(new BigInteger("48"))));




        System.out.println("********");
        for (Object i: rsa.keys(20000, 20100)
        ) {
            System.out.println(i);
        }
        System.out.println("********");

        //System.out.println(rsa.inverse(5, 72));

        System.out.println();

        System.out.println(rsa.cipher(new BigInteger("48")));

        //System.out.println(rsa.d);
        //System.out.println(rsa.e);

        System.out.println(rsa.message(rsa.cipher(new BigInteger("48"))));


        //System.out.println(rsa.message(new BigInteger("55")));

        //System.out.println((Boolean.getBoolean(String.valueOf(rsa.e.compareTo(rsa.d)))));
    }

}
