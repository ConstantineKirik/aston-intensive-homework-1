package homework1.myList.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    public void init(){
        myArrayList = new MyArrayList<>(3);
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(1);
    }

    @Test
    void addElementTest() {
        boolean result = myArrayList.add(1);

        assertTrue(result);
    }

    @Test
    void addElementByIndexTest(){
        myArrayList.add(1, 2);

        Integer actual = myArrayList.get(1);

        Integer expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    void addElementByIndexExceptionTest(){
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.add(20, 2));
    }

    @Test
    void getElementByIndexTest(){
        Integer actual = myArrayList.get(0);

        Integer expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void getElementByIndexExceptionTest(){
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(-1));
    }

    @Test
    void removeElementByIndexTest(){
        Integer actual = myArrayList.remove(0);

        Integer expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void clearListTest(){
        myArrayList.clear();
        Integer actualSize = myArrayList.size();

        Integer expectedSize = 0;

        assertEquals(expectedSize, actualSize);
    }
}
