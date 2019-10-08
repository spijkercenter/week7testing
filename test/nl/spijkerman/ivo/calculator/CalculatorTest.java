package nl.spijkerman.ivo.calculator;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class CalculatorTest {
    // ctrl alt I
    // ctrl alt O
    // ctrl alt L

    // F2

    // Alt Enter
    // Alt Insert

    // sout
    // psvm

    @Test
    void testAdd_for2and3_expect5() {

        // Arrange
        Calculator sut = new Calculator(2);

        // Act
        sut.add(3);

        // Assert
        assertEquals(5, sut.read());
    }

    @Test
    void testMultiply_for2and3_expect6() {
        // Arrange
        Calculator sut = new Calculator(2);

        // Act
        sut.mulitply(3);

        // Assert
        assertEquals(6, sut.read());
    }

    @Test
    void testRead_for2_expect2() {
        // Arrange
        Calculator sut = new Calculator(2);

        // Act
        int actual = sut.read();

        // Assert
        assertEquals(2, actual);
    }

    private void testFactorial_forX_expectY(int initialValue, int expected) {
        // Arrange
        Calculator sut = new Calculator(initialValue);

        // Act
        sut.factorial();

        // Assert
        assertEquals(expected, sut.read());
    }

    @Test
    void testFactorial_for1_expect1() {
        testFactorial_forX_expectY(1, 1);
    }

    @Test
    void testFactorial_for4_expect24() {
        testFactorial_forX_expectY(4, 24);
    }

    @Test
    void testFactorial_forMinus4_expectIllegalStateException() {
        // Arrange
        Calculator sut = new Calculator(-4);

        // Act && Assert
        assertThrows(IllegalStateException.class, sut::factorial
        );
    }

    @TestFactory
    Stream<DynamicTest> testAdd_forMany_expectSuccess() {
        int lowerBound = -100;
        int upperBound = 100;

        return IntStream.rangeClosed(lowerBound, upperBound).mapToObj(x -> {
            return dynamicTest(x + " + " + 2, () -> {
                // Arrange
                int expected = x + 2;
                Calculator sut = new Calculator(x);

                // Act
                sut.add(2);

                // Assert
                assertEquals(expected, sut.read());
            });
        });
    }
}