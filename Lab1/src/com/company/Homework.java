package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Homework {
//    Let n, p be two integers and C1,...,Cm a set of letters (the alphabet), all given as a command line arguments.
//    Validate the arguments!
//    Create an array of n strings (called words), each word containing exactly p characters from the given alphabet.
//    Display on the screen the generated array.

    static void createWords(List<String> letters, int n, int p) {
        List<String> words = new ArrayList<String>();
        for (int i=0; i<n; i++) {
            // create the i-th word
            String[] word = new String[p];
            for (int letter=0; letter<p; letter++){
                Random rand = new Random();
                int randomIndex = rand.nextInt(letters.size());
                word[letter] = letters.get(randomIndex);
                letters.remove(randomIndex);
            }
            System.out.println(Arrays.toString(word));
            //words.add(String.valueOf(word));
        }
        //return words;
    }

//    Two words are neighbors if they have a common letter.
//    Create a boolean n x n matrix, representing the adjacency relation of the words.
//    Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen.
//    For larger n display the running time of the application in nanoseconds (DO NOT display the data structure!).
//    Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
//    Launch the application from the command line, for example: java Lab1 100 7 A C G T.

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.exit(-1); // not enough arguments have been passed
        }
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        System.out.println("n = " + n);
        System.out.println("p = " + p);
        System.out.println("m = " + m);  // should be 26
        List<String> C = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        System.out.println(Arrays.toString(C.toArray()));
        createWords(C, n, p);

    }
}
