package com.genesys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneCombinationsTest {

    private PhoneCombinations solver;

    @BeforeEach
    void setUp() {
        solver = new PhoneCombinations();
    }

    /**
     * Test cases for PhoneCombinations.letterCombinations(String digits)
     */
    @Test
    @DisplayName("Example 1: digits = \"23\" → 9 combinations, sorted")
    void testExample1() {
        List<String> result = solver.letterCombinations("23");
        assertEquals(9, result.size());
        assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result);
    }

    /**
     * Additional test cases to cover edge cases and typical scenarios
     */

    @Test
    @DisplayName("Example 2: digits = \"\" → empty list")
    void testExample2_emptyInput() {
        List<String> result = solver.letterCombinations("");
        assertTrue(result.isEmpty());
    }

    /**
     * Tests for single digits, repeated digits, maximum length, sorting, and
     * invalid input
     */

    @Test
    @DisplayName("Example 3: digits = \"2\" → [\"a\",\"b\",\"c\"]")
    void testExample3_singleDigit() {
        List<String> result = solver.letterCombinations("2");
        assertEquals(List.of("a", "b", "c"), result);
    }

    /**
     * Additional tests for edge cases and typical scenarios, including:
     * - Null input
     * - Digits with 4 letters (7 and 9)
     * - Repeated digits
     * - Maximum length (4 digits)
     * - Sorting verification
     */

    @Test
    @DisplayName("Null input → empty list")
    void testNullInput() {
        List<String> result = solver.letterCombinations(null);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Single digit '9' → 4 letters (wxyz)")
    void testDigit9_fourLetters() {
        List<String> result = solver.letterCombinations("9");
        assertEquals(List.of("w", "x", "y", "z"), result);
    }

    @Test
    @DisplayName("Single digit '7' → 4 letters (pqrs)")
    void testDigit7_fourLetters() {
        List<String> result = solver.letterCombinations("7");
        assertEquals(List.of("p", "q", "r", "s"), result);
    }

    @Test
    @DisplayName("Two identical digits '22' → 9 combinations")
    void testRepeatedDigit() {
        List<String> result = solver.letterCombinations("22");
        assertEquals(9, result.size());
        assertEquals(List.of("aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc"), result);
    }

    @Test
    @DisplayName("Three digits '234' → 27 combinations")
    void testThreeDigits() {
        List<String> result = solver.letterCombinations("234");
        assertEquals(27, result.size());
        // Verify first and last entries are correct (sorted)
        assertEquals("adg", result.get(0));
        assertEquals("cfi", result.get(26));
    }

    @Test
    @DisplayName("Four digits '2345' → 81 combinations")
    void testFourDigits_maxLength() {
        List<String> result = solver.letterCombinations("2345");
        assertEquals(81, result.size());
    }

    @Test
    @DisplayName("Result is sorted alphabetically")
    void testOutputIsSorted() {
        List<String> result = solver.letterCombinations("79");
        for (int i = 0; i < result.size() - 1; i++) {
            assertTrue(result.get(i).compareTo(result.get(i + 1)) <= 0,
                    "List is not sorted at index " + i);
        }
    }

    /**
     * Test for invalid digit input (e.g., '1' or '0') which should throw
     * IllegalArgumentException
     */
    @Test
    @DisplayName("Invalid digit throws IllegalArgumentException")
    void testInvalidDigit() {
        assertThrows(IllegalArgumentException.class,
                () -> solver.letterCombinations("1"));
    }
}
