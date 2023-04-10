package org.aads.task1Lesson2;

import org.junit.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    public Graph g;
    @Before
    public void prepare(){
        g = new Graph();
    }

    @Test
    public void test1(){
        g.add(1, 2);
        g.add(2, 6);
        g.add(3,4);
        g.add(4,6);
        g.add(5,4);

        List<Integer> nodes = g.findNumberOfPath(6,2);
        assertEquals(3, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test2(){
        g.add(1,3);
        g.add(3,5);
        g.add(5,8);
        g.add(2,3);
        g.add(4,3);
        g.add(5,4);
        g.add(6,5);
        g.add(7,6);

        List<Integer> nodes = g.findNumberOfPath(8,6);
        assertEquals(4, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test3(){
        g.add(1,2);
        g.add(2,3);
        g.add(1,3);
        g.add(3,5);
        g.add(5,4);
        g.add(4,3);
        g.add(5,7);
        g.add(5,6);
        g.add(6,10);
        g.add(10,7);
        g.add(8,9);

        List<Integer> nodes = g.findNumberOfPath(7,6);
        assertEquals(4, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test4(){
        g.add(1,2);
        g.add(2,3);
        g.add(3,4);
        g.add(4,5);
        g.add(5,6);
        g.add(11,10);
        g.add(10,9);
        g.add(9,8);
        g.add(8,7);
        g.add(7,1);
        g.add(7,2);
        g.add(2,8);
        g.add(8,3);
        g.add(3,9);
        g.add(9,4);
        g.add(4,10);
        g.add(10,5);
        g.add(5,11);
        g.add(6,11);
        g.add(12,13);
        g.add(13,14);
        g.add(14,15);
        g.add(7,12);
        g.add(12,8);
        g.add(8,13);
        g.add(13,9);
        g.add(9,14);
        g.add(14,10);
        g.add(10,15);
        g.add(15,11);
        g.add(6,16);
        g.add(11,16);
        g.add(15,16);


        List<Integer> nodes = g.findNumberOfPath(16,14);
        //assertEquals(3, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test5(){
        g.add(1,2);

        List<Integer> nodes = g.findNumberOfPath(1,1);
        assertEquals(0, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test6(){
        List<Integer> nodes = g.findNumberOfPath(1,0);
        assertEquals(1, nodes.size());
        System.out.println(nodes);
        nodes = g.findNumberOfPath(1,1);
        assertEquals(0, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test7(){
        g.add(1,2);

        List<Integer> nodes = g.findNumberOfPath(2,1);
        assertEquals(1, nodes.size());
        System.out.println(nodes);
    }

    @Test
    public void test8(){
        g.add(1,2);
        g.add(2,1);

        List<Integer> nodes = g.findNumberOfPath(2,5);
        assertEquals(1, nodes.size());
        System.out.println(nodes);
    }
}
