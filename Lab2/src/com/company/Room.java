package com.company;

/**
 * @author: Andreea Munteanu, group X
 */
public class Room {
    // Each room has a name, a type and a capacity.

    private String name;
    private String type;
    private int capacity;

    public Room(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    /**
     *
     * for generating the getters and setters: code -> generate -> getters and setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
