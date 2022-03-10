package com.company;

import java.util.*;

/**
 * @author: Andreea Munteanu, group X
 */
public class Network {
    public static void main(String[] args) {

        // creating the nodes in the example:
        Computer v1 = new Computer("Computer A", "46:7A:2C:9A:68:CE", "192.168.1.1", 8);
        Router v2 = new Router("Router A", "69:FD:77:4F:CB:37", "144.16.91.27");
        Switch v3 = new Switch("Switch A", "DB:DE:14:74:6F:31");
        Switch v4 = new Switch("Switch B", "84:D3:7A:A6:3A:64");
        Router v5 = new Router("Router B", "D8:B2:72:E9:8E:68", "160.87.151.74");
        Computer v6 = new Computer("Computer B", "FC:B0:ED:2C:06:88", "61.198.171.205", 12);

        // creating the list of nodes:
        List<Node> network = new ArrayList<>();
        network.add(v1);
        network.add(v2);
        network.add(v3);
        network.add(v4);
        network.add(v5);
        network.add(v6);

        // print nodes in the example:
        for (Node node : network) {
            node.printNode();
        }

    }

}
