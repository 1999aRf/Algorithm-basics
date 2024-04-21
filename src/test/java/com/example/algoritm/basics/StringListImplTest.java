package com.example.algoritm.basics;

import com.example.algoritm.basics.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private StringListImpl list;

    @BeforeEach
    void setUp() {
        list = new StringListImpl(2);
    }

    @Test
    void testAdd() {
        list.add("item1");
        assertEquals(1, list.size());
        assertEquals("item1", list.get(0));
    }

    @Test
    void testAddAtIndex() {
        list.add("item1");
        list.add(0, "item2");
        assertEquals(2, list.size());
        assertEquals("item2", list.get(0));
        assertEquals("item1", list.get(1));
    }

    @Test
    void testSet() {
        list.add("item1");
        String oldItem = list.set(0, "newItem");
        assertEquals("item1", oldItem);
        assertEquals("newItem", list.get(0));
    }

    @Test
    void testRemoveByItem() {
        list.add("item1");
        list.add("item2");
        list.remove("item1");
        assertEquals(1, list.size());
        assertEquals("item2", list.get(0));
    }

    @Test
    void testRemoveByIndex() {
        list.add("item1");
        list.add("item2");
        String removedItem = list.remove(0);
        assertEquals("item1", removedItem);
        assertEquals(1, list.size());
        assertEquals("item2", list.get(0));
    }

    @Test
    void testContains() {
        list.add("item1");
        assertTrue(list.contains("item1"));
        assertFalse(list.contains("item2"));
    }

    @Test
    void testIndexOf() {
        list.add("item1");
        assertEquals(0, list.indexOf("item1"));
        assertEquals(-1, list.indexOf("item2"));
    }

    @Test
    void testLastIndexOf() {
        list.add("item1");
        list.add("item1");
        assertEquals(1, list.lastIndexOf("item1"));
    }

    @Test
    void testGet() {
        list.add("item1");
        assertEquals("item1", list.get(0));
    }

    @Test
    void testEquals() {
        list.add("item1");
        StringListImpl otherList = new StringListImpl(2);
        otherList.add("item1");
        assertTrue(list.equals(otherList));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add("item1");
        assertEquals(1, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("item1");
        assertFalse(list.isEmpty());
    }

    @Test
    void testClear() {
        list.add("item1");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testToArray() {
        list.add("item1");
        list.add("item2");
        String[] expectedArray = {"item1", "item2"};
        assertArrayEquals(expectedArray, list.toArray());
    }

    // Тесты на исключения
    @Test
    void testAddNull() {
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    void testAddAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, "item"));
    }

    @Test
    void testSetNull() {
        list.add("item1");
        assertThrows(NullPointerException.class, () -> list.set(0, null));
    }

    @Test
    void testSetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "item"));
    }

    @Test
    void testRemoveNull() {
        assertThrows(NullPointerException.class, () -> list.remove(null));
    }

    @Test
    void testRemoveNotFound() {
        list.add("item1");
        assertThrows(RuntimeException.class, () -> list.remove("item2"));
    }

    @Test
    void testRemoveIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testEqualsNull() {
        assertThrows(NullPointerException.class, () -> list.equals(null));
    }

    // Дополнительные тесты на граничные условия, поведение при расширении внутреннего массива и т.д.
}