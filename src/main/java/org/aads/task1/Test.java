package org.aads.task1;

import static junit.framework.TestCase.*;

public class Test {
    private Sequence check = new Sequence();
    @org.junit.Test
    public void test1(){
        assertTrue(check.check("()[]{}"));
    }
    @org.junit.Test
    public void test2(){
        assertFalse(check.check("()[](]"));
    }
    @org.junit.Test
    public void test3(){
        assertFalse(check.check("(][)"));
    }
    @org.junit.Test
    public void test4(){
        assertFalse(check.check("()[]{}}"));
    }
}
