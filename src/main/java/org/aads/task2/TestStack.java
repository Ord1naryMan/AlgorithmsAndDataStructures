package org.aads.task2;

import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class TestStack {
    FindMin test = new FindMin();
    @org.junit.Test
    public void test1(){
        assertEquals(
                Arrays.toString(new int[]{1, 4}),
                Arrays.toString(test.findMinStack(new int[]{1, 2, 3, 4, 5}, 3))
        );
    }

    @org.junit.Test
    public void test2(){
        assertEquals(
                Arrays.toString(new int[]{0, 1}),
                Arrays.toString(test.findMinStack(new int[]{1, 1, 1, 1, 1, 1}, 1))
        );
    }
    @org.junit.Test
    public void test3(){
        assertEquals(
                Arrays.toString(new int[]{0, 0}),
                Arrays.toString(test.findMinStack(new int[]{0, 0, 0, 1, 0, 0}, 1))
        );
    }
    @Test
    public void test4(){
        assertEquals(
                Arrays.toString(new int[]{1, 5}),
                Arrays.toString(test.findMinStack(new int[]{3, 2, 1, 4, 8, 7, 6, 5}, 4))
        );
    }
    @org.junit.Test
    public void test5(){
        assertEquals(
                Arrays.toString(new int[]{1, 0}),
                Arrays.toString(test.findMin(new int[]{1, 2, 4, 5, 3}, 3))
        );
    }
}
