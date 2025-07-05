import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class AddNumsTest {
    @Test
    public void Testadd1() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("497");
        L2.AddStringToList("25");
        LinkedList result = AddNums.AddTwoLists(L1, L2);
        int[] expected = {2, 2, 5}; // These test results are in reverse
        int[] actual = result.getListContents();
        assertArrayEquals(expected, actual);
        String expectedStr2 = "522";
        assertEquals(expectedStr2, result.ReturnString());
    }
    @Test
    public void Testadd2() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("1");
        L2.AddStringToList("497");
        LinkedList result = AddNums.AddTwoLists(L1, L2);
        int[] expected = {8, 9, 4}; // These test results are in reverse
        int[] actual = result.getListContents();
        assertArrayEquals(expected, actual);
        String expectedStr2 = "498";
        assertEquals(expectedStr2, result.ReturnString());
    }
    @Test
    public void Testadd3() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("25");
        L2.AddStringToList("497");
        LinkedList result = AddNums.AddTwoLists(L1, L2);
        int[] expected = {2, 2, 5}; // These test results are in reverse
        int[] actual = result.getListContents();
        assertArrayEquals(expected, actual);
        String expectedStr2 = "522";
        assertEquals(expectedStr2, result.ReturnString());
    }
}