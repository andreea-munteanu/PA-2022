package com.company;

/**
 * @author: Andreea Munteanu, group X
 */
public class Router extends Node implements Identifiable {
    private String IP; // IP

    public Router(String name, String MAC, String IP) {
        super.name = name;
        super.MAC = MAC;
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
        System.out.print(", IP: " + getIP() + "\n");
    }

//    @Override
//    public int compareTo(Router other) {
//        assert this.IP != null;
//        return this.IP.compareTo(other.IP);
//    }

}
