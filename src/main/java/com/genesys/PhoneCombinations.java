package com.genesys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Phone Letter Combinations
 *
 * Given a string containing digits from 2–9 inclusive,
 * returns all possible letter combinations that the numbers could represent,
 * sorted alphabetically.
 */
public class PhoneCombinations {

    private static final Map<Character, String> PHONE_MAP = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");

    /**
     * Returns all possible letter combinations for the given digit string,
     * sorted alphabetically.
     *
     * @param digits a string of digits (2–9), length 0–4
     * @return sorted list of letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return results;
        }

        backtrack(digits, 0, new StringBuilder(), results);
        Collections.sort(results);
        return results;
    }

    /**
     * Backtracking helper method to generate combinations.
     * 
     * @param digits
     * @param index
     * @param current
     * @param results
     */
    private void backtrack(String digits, int index, StringBuilder current, List<String> results) {
        if (index == digits.length()) {
            results.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = PHONE_MAP.get(digit);

        if (letters == null) {
            throw new IllegalArgumentException("Invalid digit: " + digit + ". Only digits 2–9 are supported.");
        }

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, results);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
