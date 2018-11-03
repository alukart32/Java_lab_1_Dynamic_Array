package com.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray array;

    @Before
    public void setUp() throws Exception {
       array = new DynamicArray();
    }

    @After
    public void tearDown() throws Exception {
        array = null;
    }

    @Test
    public void add() {
        // index starts from 1
        array.add(2);
        array.add(5);
        array.add(-3);
        array.add(0);

        assertEquals(4, array.getSize());

        assertEquals(5, array.getElements(2));
    }

    @Test
    public void changeAt() {
        // index starts from 1
        array.add(45);
        array.add(11);
        array.add(-32);

        array.changeAt(3, 99);
        assertEquals(99, array.getElements(3));
    }

    @Test
    public void deleteAt() {
        array.add(12);
        array.add(1);
        array.add(67);
        array.add(45);
        array.add(-15);
        array.add(-76);

        array.deleteAt(3);

        assertEquals(5, array.getSize());
        assertNotEquals(67, array.getElements(3));
    }
}