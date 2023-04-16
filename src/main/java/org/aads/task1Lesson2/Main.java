package org.aads.task1Lesson2;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph fileGraph1 = new Graph();

        File file1 = Path.of("src", "main", "resources", "task1Lesson2", "test1.graph").toFile();

        System.out.println(file1.exists());

        fileGraph1.readFromFile(file1);


        System.out.println("First file test:");
        List<Integer> nodes = fileGraph1.findNumberOfPath(6,2);
        System.out.println(nodes);
    }
}