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

    public static void printNetwork() {
        for (Node node : network) {
            node.printNode();
        }
    }

    public static void printFullNetwork() {
        /*
        Print nodes, costs included.
         */
        System.out.println("\n######################## PRINT NETWORK ########################\n");
        for (Node node : network) {
            node.printNode();
        }
        for (Node node: network) {
            node.printCostForNode();
        }
    }

    public static void createNetwork() {
        // creating the nodes in the example:
        Computer v1 = new Computer("Computer A", "Y6:7A:2C:9A:68:CE", "192.168.1.1", 8);
        Router v2 = new Router("Router A", "69:FD:77:4F:CB:37", "144.16.91.27");
        Switch v3 = new Switch("Switch A", "DB:DE:14:74:6F:31");
        Switch v4 = new Switch("Switch B", "84:D3:7A:A6:3A:64");
        Router v5 = new Router("Router B", "Z8:B2:72:E9:8E:68", "160.87.151.74");
        Computer v6 = new Computer("Computer B", "FC:B0:ED:2C:06:88", "161.198.171.205", 12);

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

    public static void sortAndPrintIdentifiableNodes(List<Node> myNetwork) {
        /*
        Method for printing and sorting (by address) identifiable nodes in the network.
         */

        // create list of identifiable nodes in the network:
        List<Node> identifiableNodes = new ArrayList<>();
        for (Node node : myNetwork) {
            if (node instanceof Identifiable) {
                // add to list of identifiable nodes
                identifiableNodes.add(node);
            }
        }

        // sort list:
        Collections.sort(identifiableNodes, Node::compareTo);

        // print list:
        System.out.println("\n##################### SORTED IDENTIFIABLE #####################\n");
        for (Node node : identifiableNodes) {
            node.printNode();
        }
    }

    // -------------------------------------------- DIJKSTRA ---------------------------------------------

    public static int[][] createAdjacencyMatrix(int n) {
        /*
        Creating the adjacency matrix necessary for Dijkstra.
         */
        int[][] adjMat = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                adjMat[i][j] = adjMat[j][i] = 0;
            }
        }
        int index = 1;
        for (Node node: network) {
            int finalIndex = index;
            node.cost.forEach((key, value) -> adjMat[finalIndex][network.indexOf(key) + 1] =
                    adjMat[network.indexOf(key) + 1][finalIndex] = value);
            index = index + 1;
        }

//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=n; j++) {
//                System.out.print(adjMat[i][j] + " ");
//            }
//            System.out.println();
//        }
         return adjMat;
    }

    public static void evalNeighbors(Node currentNode, HashSet<Integer> settled, int[][] adjMat, int[] distance,
                                     PriorityQueue<Node> priorityQueue) {
        /*
        Method for evaluating the unvisited neighbors of a node at a certain time.
        We update the total distance between neighbors and add node to priority queue.
         */
        int edgeDistance, newDistance = -1;

        for (int destinationNode = 1; destinationNode <= network.size(); destinationNode++)
        {
            if (!settled.contains(destinationNode))
            {
                if (adjMat[network.indexOf(currentNode)][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDistance = adjMat[network.indexOf(currentNode)][destinationNode];
                    newDistance = distance[network.indexOf(currentNode)] + edgeDistance;
                    if (newDistance < distance[destinationNode])
                        distance[destinationNode] = newDistance;
                    priorityQueue.add(network.get(destinationNode));
                }
            }
        }
    }

    public static void Dijkstra(Node start, List<Node> myNetwork) {
        /*
        Implementation of Dijkstra starting from node "start".
         */

        int numberOfNodes = network.size();
        int currentIndex = myNetwork.indexOf(start);
        int adjMat[][] = createAdjacencyMatrix(numberOfNodes);
        HashSet<Integer> settled = new HashSet<Integer>(); // hash because every node should only appear once in queue
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(numberOfNodes, (Comparator<? super Node>) new Node());

        int[] distance = new int[numberOfNodes];
        int[] visited = new int[numberOfNodes];

        for (int i=0; i < numberOfNodes; i++) {
            // initialize lists:
            distance[i] =  Integer.MAX_VALUE;
            visited[i] = 0;
        }
        distance[currentIndex] = 0; // distance from node to the same node is always 0
        visited[currentIndex] = 1;  // start vertex is considered visited
        priorityQueue.add(start);

        Node s = start;

        while (!priorityQueue.isEmpty()) {
            s = priorityQueue.remove();
            settled.add(network.indexOf(s));
            evalNeighbors(s, settled, adjMat, distance, priorityQueue);
        }

        System.out.println("\n########################### DIJKSTRA ##########################\n");
        System.out.println("The Shorted Path to all nodes are ");
        for (int i = 1; i < distance.length ; i++)
        {
            System.out.println(s + " to " + i + " is " + distance[i]);
        }
    }

    public static void main(String[] args) {
        createNetwork();
        printFullNetwork();
        sortAndPrintIdentifiableNodes(network);
        // int res = v6.convertCapacityTo("MB");
        createAdjacencyMatrix(network.size());
        Dijkstra(network.get(0), network);
    }

}
