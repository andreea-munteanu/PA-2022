package com.company;

/**
 * @author: Andreea Munteanu, group X
 */
public class Switch extends Node {
    // name and location from Node
    public String MAC;

    public Switch (String name, String MAC) {
        this.name = name;
        this.MAC = MAC;
    }

    public void setName(String name) {
        this.name = name + "(switch)";
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public void printNode() {
        System.out.println("name: " + getName() + ", MAC: " + getMAC());
    }
}
