package ru.autoqa.sandbox;

public class Primes {

    public static boolean isPrimeFor(int n){
        for( int i = 2; i < n/2 ; i++){
           if (n % i ==0){
               return false;
           }
        }
        return true;
    }

    public static boolean isPrimeFor(long n){
        for( int i = 2; i < n/2 ; i++){
            if (n % i ==0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhile(int n){
       int i = 2;
        while(i < n/2 ){
            if (n % i ==0){
                return false;
            }
           i++;
        }
        return true;
    }
}
