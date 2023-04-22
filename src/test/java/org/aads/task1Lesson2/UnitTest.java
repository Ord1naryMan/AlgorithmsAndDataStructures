package org.aads.task1Lesson2;

import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest {

    public static Stream<Arguments> testCasesProvider() {
        return Stream.of(
                        //name  supplierMethod,  ansLength, fromNode, pathLen
          Arguments.of("1", firstExample(new Graph()), 3, 6, 2),
          Arguments.of("2", secondExample(new Graph()), 4, 8, 6),
          Arguments.of("3", thirdExample(new Graph()), 4, 7, 6),
          Arguments.of("4", fourthExample(new Graph()), 12, 16, 4),
          Arguments.of("5", fifthExample(new Graph()), 0, 1, 1),
          Arguments.of("7", seventhExample(new Graph()), 1, 2, 1),
          Arguments.of("8", eighthExample(new Graph()), 1, 2, 5)
        );
    }

    @ParameterizedTest(name = "graph_{0}_test")
    @MethodSource("testCasesProvider")
    public void testRunner(String name, Graph g, int expected, int fromNode, int pathLen) {
        List<Integer> nodes = g.findNumberOfPath(fromNode, pathLen);
        assertEquals(expected, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test6() {
        Graph g = new Graph();
        List<Integer> nodes = g.findNumberOfPath(1, 0);
        assertEquals(1, nodes.size());
        System.out.println(nodes);
        nodes = g.findNumberOfPath(1, 1);
        assertEquals(0, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void correctFileTest() {
        Graph fileGraph1 = new Graph();
        Graph fileGraph2 = new Graph();
        File file1 = Path.of("src", "main", "resources", "task1Lesson2", "test1.graph").toFile();
        File file2 = Path.of("src", "main", "resources", "task1Lesson2", "test2.graph").toFile();
        fileGraph1.readFromFile(file1);
        fileGraph2.readFromFile(file2);

        System.out.println("First file test:");
        List<Integer> nodes1 = fileGraph1.findNumberOfPath(6, 2);
        assertEquals(3, nodes1.size());
        System.out.println(nodes1);

        System.out.println("Second file test:");
        List<Integer> nodes2 = fileGraph2.findNumberOfPath(8, 6);
        assertEquals(4, nodes2.size());
        System.out.println(nodes2);
    }

    @Test
    public void nonExistingFileTest() {
        Graph fileGraph1 = new Graph();
        File file1 = Path.of("src", "main", "resources", "task1Lesson2", "randomFile.graph").toFile();
        assertFalse(fileGraph1.readFromFile(file1));
    }

    @Test
    public void emptyFileTest() {
        Graph fileGraph1 = new Graph();
        File file1 = Path.of("src", "main", "resources", "task1Lesson2", "emptyFile.graph").toFile();
        assertFalse(fileGraph1.readFromFile(file1));
    }

    @Test
    public void toStringTest() {
        System.out.println(firstExample(new Graph()));
    }

    @Test
    public void containsPathTest() {
        Graph g = secondExample(new Graph());

        assertTrue(g.containsPath(1, 8));
        assertTrue(g.containsPath(1, 4));
        assertFalse(g.containsPath(1, 6));
        assertFalse(g.containsPath(5, 7));
        assertTrue(g.containsPath(3, 3));
        assertFalse(g.containsPath(100, 101));
        assertTrue(g.containsPath(100, 100));
    }

    public static Graph firstExample(Graph g) {
        g.add(1, 2);
        g.add(2, 6);
        g.add(3, 4);
        g.add(4, 6);
        g.add(5, 4);
        return g;
    }

    public static Graph secondExample(Graph g) {
        g.add(1, 3);
        g.add(3, 5);
        g.add(5, 8);
        g.add(2, 3);
        g.add(4, 3);
        g.add(5, 4);
        g.add(6, 5);
        g.add(7, 6);
        return g;
    }

    public static Graph thirdExample(Graph g) {
        g.add(1, 2);
        g.add(2, 3);
        g.add(1, 3);
        g.add(3, 5);
        g.add(5, 4);
        g.add(4, 3);
        g.add(5, 7);
        g.add(5, 6);
        g.add(6, 10);
        g.add(10, 7);
        g.add(8, 9);
        return g;
    }

    public static Graph fourthExample(Graph g) {
        g.add(1, 2);
        g.add(2, 3);
        g.add(3, 4);
        g.add(4, 5);
        g.add(5, 6);
        g.add(11, 10);
        g.add(10, 9);
        g.add(9, 8);
        g.add(8, 7);
        g.add(7, 1);
        g.add(7, 2);
        g.add(2, 8);
        g.add(8, 3);
        g.add(3, 9);
        g.add(9, 4);
        g.add(4, 10);
        g.add(10, 5);
        g.add(5, 11);
        g.add(6, 11);
        g.add(12, 13);
        g.add(13, 14);
        g.add(14, 15);
        g.add(7, 12);
        g.add(12, 8);
        g.add(8, 13);
        g.add(13, 9);
        g.add(9, 14);
        g.add(14, 10);
        g.add(10, 15);
        g.add(15, 11);
        g.add(6, 16);
        g.add(11, 16);
        g.add(15, 16);
        return g;
    }

    public static Graph fifthExample(Graph g) {
        g.add(1, 2);
        return g;
    }

    public static Graph seventhExample(Graph g) {
        g.add(1, 2);
        return g;
    }

    public static Graph eighthExample(Graph g) {
        g.add(1, 2);
        g.add(2, 1);
        return g;
    }
}
