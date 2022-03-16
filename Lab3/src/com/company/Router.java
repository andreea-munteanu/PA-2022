package com.company;

/**
 * @author: Andreea Munteanu, group X
 */
public class Router extends Node implements Identifiable {
    private String address; // IP

    public Router(String name, String MAC, String address) {
        super.name = name;
        super.MAC = MAC;
        this.address = address;
    }

    @Override
    public void setIP(String someIP) {
        this.address = someIP;
    }

    @Override
    public String getIP() {
        return this.address;
    }

    public void setName(String name) {
        super.name = name + "(router)";
    }

    public String getMac() {
        return MAC;
    }

    public void setMac(String MAC) {
        super.MAC = MAC;
    }

    public void printNode() {
        super.printNode();
        System.out.print("IP: " + getIP() + "\n");
    }

}
