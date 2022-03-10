package com.company;

/**
 * @author: Andreea Munteanu, group X
 */
class Computer extends Node implements Identifiable, Storage { //implements Identifiable, Storage {
    // name and location from Node
    public String MAC;
    public String IP; // Identifiable
    public int storageCapacity; // in GB; from Storage

    public Computer(String name, String MAC, String IP, int storageCapacity) {
        this.name = name;
        this.MAC = MAC;
        this.IP = IP;
        this.storageCapacity = storageCapacity;
    }

    public void setName(String name) {
        this.name = name + "(PC)";
    }

    @Override
    public void setIP(String someIP) {
        this.IP = someIP;
    }

    @Override
    public String getIP() {
        return this.IP;
    }

    public void printCapacity() {
        System.out.println("Capacity: " + this.storageCapacity);
    }

    public void setStorage(int capacity) {
        this.storageCapacity = capacity;
    }

    public int getStorage() {
        return this.storageCapacity;
    }
    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void printNode() {
        System.out.println("name: " + getName() + ", MAC: " + getMAC() + ", IP: " + getIP() + ", memory: " + getStorage() + "GB");
    }

}
