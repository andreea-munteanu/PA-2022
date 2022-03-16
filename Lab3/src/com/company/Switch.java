package com.company;

/**
 * @author: Andreea Munteanu, group X
 */
public class Switch extends Node {
    public Switch (String name, String MAC) {
        super.name = name;
        super.MAC = MAC;
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
        super.printNode();
        System.out.println();
    }

}
