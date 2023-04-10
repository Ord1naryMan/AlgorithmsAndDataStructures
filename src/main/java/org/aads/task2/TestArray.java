package org.aads.task2;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class TestArray {
    FindMin test = new FindMin();
    @org.junit.Test
    public void test1(){
        assertEquals(
                Arrays.toString(new int[]{1, 4}),
                Arrays.toString(test.findMin(new int[]{1, 2, 3, 4, 5}, 3))
        );
    }

    @org.junit.Test
    public void test2(){
        assertEquals(
                Arrays.toString(new int[]{0, 1}),
                Arrays.toString(test.findMin(new int[]{1, 1, 1, 1, 1, 1}, 1))
        );
    }
    @org.junit.Test
    public void test3(){
        assertEquals(
                Arrays.toString(new int[]{0, 0}),
                Arrays.toString(test.findMin(new int[]{0, 0, 0, 1, 0, 0}, 1))
        );
    }
    @org.junit.Test
    public void test4(){
        assertEquals(
                Arrays.toString(new int[]{1, 0}),
                Arrays.toString(test.findMin(new int[]{1, 2, 4, 5, 3}, 3))
        );
    }
}
