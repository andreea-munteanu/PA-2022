/**
 * @author: Andreea Munteanu, group X
 */
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class City {

    public static boolean streetContainsIntersectionJoining3Streets(LinkedList<Street> streetLinkedList, Street street, int n) {
        /*
        Checks whether an intersection of a street joins more than n streets and returns true or false.
         */
        String streetName = street.getName(); // ex: BC
        String intersection1Name = String.valueOf(streetName.charAt(0)); // B
        String intersection2Name = String.valueOf(streetName.charAt(1)); // C

        int count1 = 0;
        int count2 = 0;

        /*
        pasi:
        1. extrage intersectiile (ex.: B, C)
        2. parseaza strazile (for strada in strazi)
        3. daca intersectia B apare in denumirea strazii, count1 ++
        4. daca intersectia C apare in denumirea strazii, count2 ++
        5. daca un count >= n --> returneaza stringul corespunzator
         */

        for (Street value : streetLinkedList) {
            String name = value.getName();
            if (name.contains(intersection1Name)) count1 += 1;
            if (name.contains(intersection2Name)) count2 += 1;
        }

        return (count1 >=n || count2 >= n);

    }

    public static List<Street> createListOfStreetsStartingFromIntersection(Set<Intersection> intersections) {
        return null;
    }

    public static void main(String[] args) {
        // ------------------------------------- CREATING THE CITY --------------------------------------------
        Main.main();

        LinkedList<Street> cityStreets = Main.getStreets(); // the streets
        Set<Intersection> cityIntersections = Main.getIntersections(); // the intersections
        Map<Intersection, List<Street>> cityMap = new HashMap<>(); // the map of the city

        cityMap.put(new Intersection("A"), Arrays.asList(cityStreets.get(4), cityStreets.get(5), cityStreets.get(6)));
        cityMap.put(new Intersection("B"), Arrays.asList(cityStreets.get(0), cityStreets.get(6), cityStreets.get(12)));
        cityMap.put(new Intersection("C"), Arrays.asList(cityStreets.get(1), cityStreets.get(2), cityStreets.get(9), cityStreets.get(10)));
        cityMap.put(new Intersection("D"), Arrays.asList(cityStreets.get(1), cityStreets.get(3), cityStreets.get(4), cityStreets.get(9)));
        cityMap.put(new Intersection("E"), Arrays.asList(cityStreets.get(3), cityStreets.get(10)));
        cityMap.put(new Intersection("F"), Arrays.asList(cityStreets.get(2), cityStreets.get(13)));
        cityMap.put(new Intersection("G"), Arrays.asList(cityStreets.get(5), cityStreets.get(7), cityStreets.get(13)));
        cityMap.put(new Intersection("H"), Arrays.asList(cityStreets.get(0), cityStreets.get(5), cityStreets.get(8), cityStreets.get(11)));
        cityMap.put(new Intersection("I"), Arrays.asList(cityStreets.get(4), cityStreets.get(11)));

        // display all the streets that are longer than a specified value and join at least 3 streets
        // (we chose 2 as string argument for that value)
        int value = Integer.parseInt(args[0]);
        List<Street> queriedStreets = cityStreets.stream().
                filter(p -> p.getLength() > value).
                filter(p -> streetContainsIntersectionJoining3Streets(cityStreets, p, 3)).
                collect(Collectors.toList());

        for (Street street : queriedStreets) {
            System.out.print(street.toString() + "  ");
        }

        Faker faker = new Faker();

        // ---------------------------------------- FAKE NAMES --------------------------------------------------
        // fake names for streets containing the 'A' intersection:
        for (Street street : cityStreets) {
            if (street.getName().contains("A")) {
                street.setName(faker.address().streetName());
            }
        }
        Main.printLinkedList(cityStreets);

        // fake names for intersections that are vowels:
        Iterator<Intersection> index = cityIntersections.iterator();
        List<String> vowels = new ArrayList<>();
        vowels.add("A");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        vowels.add("U");
        vowels.add("Y");
        for (Intersection intersection : cityIntersections) {
            if (vowels.contains(intersection.getName())) {
                intersection.setName(faker.address().buildingNumber());
            }
        }
        /*
        // or:
        while (index.hasNext()) {
            if (vowels.contains(index.next().getName())) {
                index.next().setName(faker.address().latitude());
            }
            index.next();
        }
        */
        Main.printIntersectionHashSet(cityIntersections);

        // -------------------------------------- SOLVING THE PROBLEM ---------------------------------------------
        // TODO

    }
}
