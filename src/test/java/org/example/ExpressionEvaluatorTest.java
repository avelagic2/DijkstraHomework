package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

/**
 * Test Class for methods
 */
class ExpressionEvaluatorTest {
    /**
     * First Unit Test
     * Basic arithmetic addition
     */
    @Test
    void evaluate1() {
        String s = new String("( ( 2 + 3 ) + 4 )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(9, Testni);
    }

    /**
     * Second Unit Test
     * Basic arithmetic subtraction
     */
    @Test
    void evaluate2() {
        String s = new String("( ( 9 - 2 ) - 4 )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(3, Testni);
    }

    /**
     * Third Unit Test
     * Combination of addition and subtraction
     */
    @Test
    void evaluate3() {
        String s = new String("( ( 2 + 5 ) - 6 )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(1, Testni);
    }

    /**
     * Fourth Unit Test
     * Testing multiplication
     */
    @Test
    void evaluate4() {
        String s = new String("( ( 2 + 8 ) * 2 )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(20, Testni);
    }

    /**
     * Fifth Unit Test
     * Testing division
     */
    @Test
    void evaluate5() {
        String s = new String("( ( 11 - 9 ) / 2 )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(1, Testni);
    }

    /**
     * Sixth Unit Test
     * Left to Right expression
     */
    @Test
    void evaluate6() {
        String s = new String("( 1 + ( 11 - 9 ) )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(3, Testni);
    }

    /**
     * Seventh Unit Test
     * Left to Right testing
     */
    @Test
    void evaluate7() {
        String s = new String("( 4 * ( 11 - 9 ) )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(8, Testni);
    }

    /**
     * Eight Unit Test
     * Double expression
     */
    @Test
    void evaluate8() {
        String s = new String("( ( 11.5 - 9.2 ) * 2.2 )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(5, Math.round(Testni));
    }

    /**
     * Ninth Unit Test
     * sqrt
     */
    @Test
    void evaluate9() {
        String s = new String("( 2 + ( 4 + sqrt ( 4 ) ) )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(8, Testni);
    }

    /**
     * Ninth Unit Test
     * Testing negative values
     */
    @Test
    void evaluate10() {
        String s = new String("( 2 * ( 4 - 8 ) )");
        Double Testni = ExpressionEvaluator.evaluate(s);
        assertEquals(-8, Testni);
    }

    /**
     * Exception Test 1
     * Testing double closed brackets
     */
    @Test
    void exceptionTest1() {
        String s = new String("( 2 + ( 4 + sqrt ( 4 ) )) )");
        Exception exception = assertThrows(RuntimeException.class,
                () -> ExpressionEvaluator.evaluate(s));
        assertAll(
                () -> assertEquals("Invalid input!",
                        exception.getMessage())
        );
    }

    /**
     * Exception Test 2
     * Testing operands
     */
    @Test
    void exceptionTest2() {
        assertThrows(RuntimeException.class,
                () -> ExpressionEvaluator.evaluate("( 4 + 3)"));
    }

    /**
     * Exception Test 3
     * Testing extra opened brackets
     */
    @Test
    void exceptionTest3() {
        assertThrows(RuntimeException.class,
                () -> ExpressionEvaluator.evaluate("(( 4 * ( 12 + 3 )"));
    }

    /**
     * Exception Test 4
     * Testing extra closed brackets
     */
    @Test
    void exceptionTest4() {
        assertThrows(RuntimeException.class,
                () -> ExpressionEvaluator.evaluate("( ( 4 * ( 12 + 3 ) ) ) )"));
    }

    /**
     * Exception Test 5
     * Testing extra ops
     */
    @Test
    void exceptionTest5() {
        assertThrows(RuntimeException.class,
                () -> ExpressionEvaluator.evaluate("( 2 * 3 + 3 )"));
    }

    /**
     * Exception Test 6
     * Testing more ops than brackets
     */
    @Test
    void exceptionTest6() {
        assertThrows(RuntimeException.class,
                () -> ExpressionEvaluator.evaluate("( 2 + 3 + )"));
    }


}
