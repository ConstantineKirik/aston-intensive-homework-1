package homework1.myList.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLinkedListTest {

    private MyLinkedList<Integer> myLinkedList;

    @BeforeEach
    public void init() {
        myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(1);
        myLinkedList.add(1);
    }

    @Test
    void addElementTest() {
        boolean result = myLinkedList.add(1);

        assertTrue(result);
    }

    @Test
    void addElementByIndexTest(){
        myLinkedList.add(1, 2);

        Integer actual = myLinkedList.get(1);

        Integer expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    void addElementByIndexExceptionTest(){
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.add(20, 2));
    }

    @Test
    void getElementByIndexTest(){
        Integer actual = myLinkedList.get(0);

        Integer expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void getElementByIndexExceptionTest(){
        assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(-1));
    }

    @Test
    void removeElementByIndexTest(){
        Integer actual = myLinkedList.remove(0);

        Integer expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void clearListTest(){
        myLinkedList.clear();
        Integer actualSize = myLinkedList.size();

        Integer expectedSize = 0;

        assertEquals(expectedSize, actualSize);
    }
}
