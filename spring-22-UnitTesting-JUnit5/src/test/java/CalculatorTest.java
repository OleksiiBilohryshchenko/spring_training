import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add(){
        System.out.println("Add method");
        int actual = Calculator.add(2,3);
        assertEquals(5, actual, "Test failed");
    }

    @Test
    void testCase1(){
        System.out.println("Test Case 1");
        fail("Not implemented yet");
    }

    @Test
    void testCase2(){
        System.out.println("Test Case 2");
        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);
    }

    @Test
    void testCase3(){
        System.out.println("Test Case 3");
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Arrays are not the same");
    }

    @Test
    void testCase4(){
        System.out.println("Test Case 4");
        String nullString = null;
        String notNullString = "Word";

        assertNull(nullString);
        assertNotNull(notNullString);

        assertNull(notNullString);
        assertNotNull(nullString);
    }

    @Test
    void testCase5(){
        System.out.println("Test Case 5");

    }


}