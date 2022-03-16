package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Andreea Munteanu, group X
 */
public abstract class Node implements Comparable<Node> {
    public String name = "node";
    public String location = "some location";
    public String MAC = "some MAC";
    public Map<Node, Integer> cost = new HashMap<>(); // should be private, made it public due to IDE warnings

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public void printCostForNode() {
        cost.forEach((key, value) -> System.out.println(name + "--" + key.name + ": " + value));
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

    @Override
    public int compareTo(Node other) {
        assert this.name != null;
        return this.name.compareTo(other.name);
    }

}
