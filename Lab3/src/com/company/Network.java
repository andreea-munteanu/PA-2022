package com.company;

import java.util.*;

/**
 * @author: Andreea Munteanu, group X
 */
public class Network {
    private static List<Node> network = new ArrayList<>();

    public static void addNode(Node node) {
        network.add(node);
    }

    public static void sortAndPrintIdentifiableNodes(List<Node> myNetwork) {
        /*
        Method for sorting and printing the identifiable nodes in the network.
         */
        int a = 5;
    }

    public static void printNetwork() {
        for (Node node : network) {
            node.printNode();
            node.printCostForNode();
            System.out.println();
        }
    }

    public static void createNetwork() {
        // creating the nodes in the example:
        Computer v1 = new Computer("Computer A", "46:7A:2C:9A:68:CE", "192.168.1.1", 8);
        Router v2 = new Router("Router A", "69:FD:77:4F:CB:37", "144.16.91.27");
        Switch v3 = new Switch("Switch A", "DB:DE:14:74:6F:31");
        Switch v4 = new Switch("Switch B", "84:D3:7A:A6:3A:64");
        Router v5 = new Router("Router B", "D8:B2:72:E9:8E:68", "160.87.151.74");
        Computer v6 = new Computer("Computer B", "FC:B0:ED:2C:06:88", "61.198.171.205", 12);

        // adding costs:
        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 20);
        v3.setCost(v4, 10);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        // creating the list of nodes:
        addNode(v1);
        addNode(v2);
        addNode(v3);
        addNode(v4);
        addNode(v5);
        addNode(v6);
    }

    public static void main(String[] args) {
        createNetwork();
        printNetwork();
        // int res = v6.convertCapacityTo("MB");
    }

}
