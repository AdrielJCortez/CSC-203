import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplyNumsTest {
    @Test
    public void TestMultiply1() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("127");
        L2.AddStringToList("52");
        LinkedList result = MultiplyLists.MultiplyNums(L1, L2);
        int [] expected = {4, 0, 6, 6}; // These test results are in reverse
        int [] actual = result.getListContents();
        assertArrayEquals(expected, actual);
        String expectedStr = "6604"; // These test results are in reverse
        String actualStr = result.ReturnString();
        assertEquals(expectedStr, actualStr);
    }
    @Test
    public void TestMultiply2() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("527");
        L2.AddStringToList("52");
        LinkedList result = MultiplyLists.MultiplyNums(L1, L2);
        int [] expected = {4, 0, 4, 7, 2}; // These test results are in reverse
        int [] actual = result.getListContents();
        assertArrayEquals(expected, actual);
        String expectedStr = "27404"; // These test results are in reverse
        String actualStr = result.ReturnString();
        assertEquals(expectedStr, actualStr);
    }
    @Test
    public void TestMultiply3() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("4294967296");
        L2.AddStringToList("256");
        LinkedList result = MultiplyLists.MultiplyNums(L1, L2);
        int[] expected = {6, 7, 7, 7, 2, 6, 1, 1, 5, 9, 9, 0, 1}; // These test results are in reverse
        int[] actual = result.getListContents();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestMultiplyByZero1() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("4294967296");
        L2.AddStringToList("0");
        LinkedList result = MultiplyLists.MultiplyNums(L1, L2);
        int[] expected = {0}; // These test results are in reverse
        int[] actual = result.getListContents();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestMultiplyByZero2() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("0");
        L2.AddStringToList("10");
        LinkedList result = MultiplyLists.MultiplyNums(L1, L2);
        int[] expected = {0}; // These test results are in reverse
        int[] actual = result.getListContents();
        assertArrayEquals(expected, actual);
    }
}
