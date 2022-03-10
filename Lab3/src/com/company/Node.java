package com.company;

// import static com.company.Identifiable.IP;

/**
 * @author: Andreea Munteanu, group X
 */
public abstract class Node {
    public String name = "node";
    public String location = "some location";

    public String getName() {
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

    public void printNode() {}
}
