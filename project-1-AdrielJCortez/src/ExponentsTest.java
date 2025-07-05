import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ExponentsTest {
    @Test
    public void Test1() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("6");
        L2.AddStringToList("8");
        LinkedList result = Exponents.power(L1, L2);
        int[] expected = {6, 1, 6, 9, 7, 6, 1}; // These test results are in reverse
        int[] actual = result.getListContents();
        assertArrayEquals(expected, actual);
        String expectedStr = "1679616";
        assertEquals(expectedStr, result.ReturnString());
    }
    @Test
    public void Test2() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("2");
        L2.AddStringToList("40");
        LinkedList result = Exponents.power(L1, L2);
        int[] expected = {6, 7, 7, 7, 2, 6, 1, 1, 5, 9, 9, 0, 1}; // These test results are in reverse
        int[] actual = result.getListContents();
        assertArrayEquals(expected, actual);
        String expectedStr = "1099511627776";
        assertEquals(expectedStr, result.ReturnString());
    }

    @Test
    public void TestEx1() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("2");
        L2.AddStringToList("1");
        LinkedList result = Exponents.power(L1, L2);
        String expectedStr = "2";
        assertEquals(expectedStr, result.ReturnString());
    }

    @Test
    public void TestEx0() {
        LinkedList L1 = new LinkedList(null, 0, null);
        LinkedList L2 = new LinkedList(null, 0, null);
        L1.AddStringToList("2");
        L2.AddStringToList("0");
        LinkedList result = Exponents.power(L1, L2);
        String expectedStr = "1";
        assertEquals(expectedStr, result.ReturnString());
    }
}
