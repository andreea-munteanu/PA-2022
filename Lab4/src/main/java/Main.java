import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Andreea Munteanu, group X
 */
public class Main {
    private static final LinkedList<Street> streetLinkedList = new LinkedList<>();
    private static final Set<Intersection> intersectionHashSet = new HashSet<>();

    public static void sortLinkedList(LinkedList<Street> list) {
        Collections.sort(list, Comparator.comparing(Street::getLength).thenComparing(Street::getName));
    }

    public static void printLinkedList(LinkedList<Street> list) {
        System.out.println("---------- PRINT LINKED LIST (STREETS) ----------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));
        }
    }

    public static void printIntersectionHashSet(Set<Intersection> inter) {
        System.out.println("---------- PRINT INTERSECTION HASHSET ----------\n" + inter);
    }

    public static void main(String[] args) {
        /**
         * Creating the streets and intersections in the example.
         * I named the vertices using capital letters (node_A, node_B etc.) s.t. the streets will be named AB, BC, CD etc.
         */

        // creating the intersections (named node_A, node_B, ...):
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "I"};
        var intersections = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Intersection("node_" + names[i]) )
                .toArray(Intersection[]::new);

//        for (Intersection node : intersections) {
//            System.out.print(node.getName() + " ");
//        }

        // creating the streets:
        Street AB = new Street("AB", 2);
        Street AH = new Street("AH", 2);
        Street AG = new Street("AG", 2);
        Street BC = new Street("BC", 3);
        Street BH = new Street("BH", 1);
        Street CD = new Street("CD", 1);
        Street CE = new Street("CE", 2);
        Street CF = new Street("CF", 1);
        Street DE = new Street("DE", 1);
        Street DI = new Street("DI", 1);
        Street FG = new Street("FG", 3);
        Street FH = new Street("CD", 2);
        Street GH = new Street("GH", 1);
        Street HI = new Street("HI", 2);

        // creating the list of streets (LinkedList) by adding all recently created streets at the end of the list:
        streetLinkedList.add(AB);
        streetLinkedList.add(AH);
        streetLinkedList.add(AG);
        streetLinkedList.add(BC);
        streetLinkedList.add(BH);
        streetLinkedList.add(CD);
        streetLinkedList.add(CE);
        streetLinkedList.add(CF);
        streetLinkedList.add(DE);
        streetLinkedList.add(DI);
        streetLinkedList.add(FG);
        streetLinkedList.add(FH);
        streetLinkedList.add(GH);
        streetLinkedList.add(HI);

        // sort list by length (and additionally then by name):
        sortLinkedList(streetLinkedList);
        printLinkedList(streetLinkedList);

        // creating the hashset of intersections:
        // the "addAll" method makes sure that the newly added element doesn't already exist in the set:
        // https://docs.oracle.com/javase/7/docs/api/java/util/Set.html#add(E)
        intersectionHashSet.addAll(Arrays.asList(intersections));
        printIntersectionHashSet(intersectionHashSet);
    }
}
