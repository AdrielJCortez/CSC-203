import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedTest {

    @Test
    public void addStart() {
        LinkedList L1 = new LinkedList(null, 0, null);
        L1.addStart(1);
        L1.addStart(5);
        L1.addStart(9);
        L1.addStart(3);
        int [] expected = {3, 9, 5, 1};
        assertArrayEquals(L1.getListContents(), expected);
        int size = L1.getSize();
        assertEquals(4, size);
    }
    @Test
    public void addEnd() {
        LinkedList L1 = new LinkedList(null, 0, null);
        L1.addEnd(1);
        L1.addEnd(5);
        L1.addEnd(9);
        L1.addEnd(3);
        int [] expected = {1, 5, 9, 3};
        assertArrayEquals(expected, L1.getListContents());
    }

    @Test
    public void TestSize() {
        LinkedList L1 = new LinkedList(null, 0, null);
        L1.AddStringToList("123");
        assertEquals(3, L1.getSize());
    }

    @Test
    public void TestCorrectOrder() {
        LinkedList L1 = new LinkedList(null, 0, null);
        L1.AddStringToList("541");
        int [] expected = {1, 4, 5};
        assertArrayEquals(expected, L1.getListContents());
    }

    @Test
    public void NullTests() {
        LinkedList L1 = new LinkedList(null, 0, null);
        assertNull(L1.ReturnString());
    }

    @Test
    public void StringToList() {
        LinkedList L1 = new LinkedList(null, 0, null);
        L1.AddStringToList("111");
        assertArrayEquals(new int[]{1, 1, 1}, L1.getListContents());
        assertEquals("111", L1.ReturnString());
    }
}
