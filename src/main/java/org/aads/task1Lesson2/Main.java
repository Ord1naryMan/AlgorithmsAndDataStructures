package org.aads.task1Lesson2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();

        g.add(1, 2);
        g.add(2, 3);
        g.add(3, 4);
        g.add(4, 2);

        List<Integer> nodes = g.findNumberOfPath(3, 5);
        System.out.println(nodes);
    }
}