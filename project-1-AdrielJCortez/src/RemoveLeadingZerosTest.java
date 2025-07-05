import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveLeadingZerosTest {
    @Test
    public void test1(){
        String str1 = "0001";
        String expected = "1";
        String actual = RemoveLeadingZeros.removeZeros(str1);
        assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        String str1 = "1";
        String expected = "1";
        String actual = RemoveLeadingZeros.removeZeros(str1);
        assertEquals(expected, actual);
    }

    @Test
    public void test3(){
        String str1 = "0000000000000000000000000002";
        String expected1 = "2";
        String str2 = "00000000000000000003";
        String expected2 = "3";
        String actual1 = RemoveLeadingZeros.removeZeros(str1);
        String actual2 = RemoveLeadingZeros.removeZeros(str2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }


}
