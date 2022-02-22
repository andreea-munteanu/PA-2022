package com.company;

public class Compulsory {

    static int checkDigit(int n) {
        // function for computing the check digit of a number n
        int sum = 0;
        while(n > 9)
        {
            sum = 0;
            while (n > 0)
            {
                sum += n%10;
                n = n/10;
            }
            n = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] languages = new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(java.util.Arrays.toString(languages));
        int n = ((int) (Math.random() * 1_000_000) * 3 + 0b10101 + 0xFF) * 6;
        int result = checkDigit(n);
        System.out.println( "Willy-nilly, this semester I will learn " + languages[result]); // Java
    }
}
