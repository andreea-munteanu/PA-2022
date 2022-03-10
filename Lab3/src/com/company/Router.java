package com.company;

/**
 * @author: Andreea Munteanu, group X
 */
public class Router extends Node implements Identifiable {
    // name and location inherited from Node
    public String MAC;
    public String IP;

    public Router(String name, String MAC, String IP) {
        this.name = name;
        this.MAC = MAC;
        this.IP = IP;
    }

    @Override
    public void setIP(String someIP) {
        this.IP = someIP;
    }

    @Override
    public String getIP() {
        return this.IP;
    }

    public void setName(String name) {
        this.name = name + "(router)";
    }

    public String getMac() {
        return MAC;
    }

    public void setMac(String MAC) {
        this.MAC = MAC;
    }

    public void printNode() {
        System.out.println("name: " + getName() + ", MAC: " + getMac() + ", IP: " + getIP());
    }

}
