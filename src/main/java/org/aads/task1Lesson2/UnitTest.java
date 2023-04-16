package org.aads.task1Lesson2;

import org.junit.*;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest {
    public Graph g;

    @Before
    public void prepare() {
        g = new Graph();
    }

    @Test
    public void test1() {
        firstExample(g);

        List<Integer> nodes = g.findNumberOfPath(6, 2);
        assertEquals(3, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test2() {
        secondExample(g);

        List<Integer> nodes = g.findNumberOfPath(8, 6);
        assertEquals(4, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test3() {
        thirdExample(g);

        List<Integer> nodes = g.findNumberOfPath(7, 6);
        assertEquals(4, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test4() {
        fourthExample(g);

        List<Integer> nodes = g.findNumberOfPath(16, 14);
        System.out.println(nodes);
    }

    @Test
    public void test5() {
        fifthExample(g);

        List<Integer> nodes = g.findNumberOfPath(1, 1);
        assertEquals(0, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test6() {
        List<Integer> nodes = g.findNumberOfPath(1, 0);
        assertEquals(1, nodes.size());
        System.out.println(nodes);
        nodes = g.findNumberOfPath(1, 1);
        assertEquals(0, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test7() {
        seventhExample(g);

        List<Integer> nodes = g.findNumberOfPath(2, 1);
        assertEquals(1, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test8() {
        eighthExample(g);

        List<Integer> nodes = g.findNumberOfPath(2, 5);
        assertEquals(1, nodes.size());
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
        firstExample(g);

        System.out.println(g);
    }

    @Test
    public void containsPathTest() {
        secondExample(g);

        assertTrue(g.containsPath(1, 8));
        assertTrue(g.containsPath(1, 4));
        assertFalse(g.containsPath(1, 6));
        assertFalse(g.containsPath(5, 7));
        assertTrue(g.containsPath(3, 3));
        assertFalse(g.containsPath(100, 101));
        assertTrue(g.containsPath(100, 100));
    }

    public static void firstExample(Graph g) {
        g.add(1, 2);
        g.add(2, 6);
        g.add(3, 4);
        g.add(4, 6);
        g.add(5, 4);
    }

    public static void secondExample(Graph g) {
        g.add(1, 3);
        g.add(3, 5);
        g.add(5, 8);
        g.add(2, 3);
        g.add(4, 3);
        g.add(5, 4);
        g.add(6, 5);
        g.add(7, 6);
    }

    public static void thirdExample(Graph g) {
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
    }

    public static void fourthExample(Graph g) {
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
    }

    public static void fifthExample(Graph g) {
        g.add(1, 2);
    }

    public static void seventhExample(Graph g) {
        g.add(1, 2);
    }

    public static void eighthExample(Graph g) {
        g.add(1, 2);
        g.add(2, 1);
    }
}
