package com.company;

public class Main {

    public enum Type {
        lab,
        lecture_hall
    }

    public static void main(String[] args) {

        /*
        Events: C1(size=100, start=8, end=10), C2(size=100, start=10, end=12), L1(size=30, start=8, end=10),
                L2(size=30, start=8, end=10), L3(size=30, start=10, end=12),
        Rooms: 401(cap=30, lab), 403(cap=30, lab), 405(cap=30, lab), 309(cap=100, lecture hall)
        */

        Event C1 = new Event("C1", 100,8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30,8, 10);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);

        Room room401 = new Room("401", "lab", 30);
        Room room403 = new Room("403", "lab", 30);
        Room room309 = new Room("309", "lecture_hall", 100);


    }
}
