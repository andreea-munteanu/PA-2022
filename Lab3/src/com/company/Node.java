package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Andreea Munteanu, group X
 */
public class Node implements Comparable<Node> {
    public String name = "node";
    public String location = "some location";
    public String MAC = "some MAC";
    public Map<Node, Integer> cost = new HashMap<>(); // should be private, made it public due to IDE warnings
//
//    public Node(int node, int cost) {
//        this.node = node;
//        this.cost = cost;
//    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMAC(String someMAC) { this.MAC = someMAC; }

    public String getMAC() { return this.MAC; }

    public void printNode() {
        System.out.print("name: " + getName() + ", MAC: " + getMAC());
    }

    public void printCostForNode() {
        cost.forEach((key, value) -> System.out.println(name + " -- " + key.name + ": " + value));
    }

    @Override
    public int compareTo(@NotNull Node other) {
        // some assertions
        assert this.name != null;
        assert this instanceof Identifiable;
        assert other instanceof Identifiable;

        String this_IP = ((Identifiable) this).getIP();
        String other_IP = ((Identifiable) other).getIP();

        if (this_IP.equals(other_IP)) {
            System.out.println("Identical IPs: not possible.");
            return -1;
        }

        return (this_IP.compareTo(other_IP));
    }

}
