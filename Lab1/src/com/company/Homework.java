package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Homework {

    static List<String> createWords(List<Character> letters, int n, int p) {
        /*
        Create an array of n strings (called words), each word containing exactly p characters from the given alphabet.
        Display on the screen the generated array.
        */
        List<String> words = new ArrayList<>();
        for (int i=0; i<n; i++) {
            // build the i-th word into a string, then add string to list of words
            StringBuilder sb = new StringBuilder();
            for (int letter = 0; letter < p; letter++) {
                Random rand = new Random();
                int randomIndex = rand.nextInt(letters.size());
                sb.append(letters.get(randomIndex));
            }
            String word = sb.toString();
            words.add(word);
        }
        for (String word : words) {
            System.out.print(word + " ");
        }
        return words;
    }


    public static boolean haveCommonLetter(String word1, String word2, int p) {
        /*
        For two words of size p, check whether they have a common letter.
         */
        boolean statement = false;
        List<Character> lettersInFirstWord = new ArrayList<>();
        for (int i=0; i<p; i++) {
            // create list of chars with characters in word1
            lettersInFirstWord.add(word1.charAt(i));
        }
        for (Character character : lettersInFirstWord) {
            // check if any characters in previously created list exist in word2
            if (word2.indexOf(character) != -1) {
                statement = true;
                break;
            }
        }
        return statement;
    }

    public static void neighbors(List<String> words, int n, int p) {
        /*
        Two words are neighbors if they have a common letter.
        Create a boolean n x n matrix, representing the adjacency relation of the words.
        Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure
        on the screen.
         */
        boolean[][] adjMatrix = new boolean[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                adjMatrix[row][col] = adjMatrix[col][row] = haveCommonLetter(words.get(row), words.get(col), p);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
        }
        /*
        Using the adjacency matrix, we can tell which words are neighbors by looking at the true values on each row.
        Ex.:
           0     1     2    3     4    5
        0 true false false true false false
        1 false true false false false true
        2 false false true true false true
        3 true false true true true true
        4 false false false true true false
        5 false true true true false true

        - words[0] will be neighbor with words[0] (itself) and words[3]
        - words[1] will be neighbor with words[1] (itself) and words[5]
        etc.

        For the data structure, we use an array of arrays:
        - first array contains neighbors of first word,
        - second array contains neighbors of the second word
        etc.
         */
        String[][] neighborWords = new String[n][];

        for (int i = 0; i < n; i++) {
            // for each word i, find its neighbors, store them in "neighbors" and finally add them to the big final array
            String[] neighbors = new String[n];
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j])
                    neighbors[j] = words.get(j);
                else
                    neighbors[j] = "_";
            }
            neighborWords[i] = neighbors;
        }

        System.out.println();
        for (int i=0; i<n; i++){
             System.out.print(words.get(i) + ": ");
             System.out.println(Arrays.deepToString(neighborWords[i]));
        }

    }

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
        List<Character> C = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o');
                //'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        System.out.println("C[26]: " + Arrays.toString(C.toArray()));

        List<String> words = createWords(C, n, p);
        // System.out.println(haveCommonLetter(words.get(0), words.get(1), p));

        neighbors(words, n, p);

        /*
        For larger n display the running time of the application in nanoseconds (DO NOT display the data structure!).
        Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
        Launch the application from the command line, for example: java Lab1 100 7 A C G T.
         */

        // de aici crapa:

//        n = 3000;
//        long startTime = System.nanoTime();
//        neighbors(words, n, p);
//        long endTime = System.nanoTime();
//        long timeDifference = endTime - startTime;
//        System.out.println("Time (nanoseconds): " + timeDifference);

    }
}
