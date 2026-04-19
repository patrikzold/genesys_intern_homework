# Phone Letter Combinations

Genesys Software Engineer Intern – Home Assignment

## Problem

Given a string of digits (2–9), return all possible letter combinations those digits could represent on a telephone keypad, sorted alphabetically.

```
2 → abc  |  3 → def  |  4 → ghi  |  5 → jkl
6 → mno  |  7 → pqrs |  8 → tuv  |  9 → wxyz
```

## Examples

| Input  | Output |
|--------|--------|
| `"23"` | `["ad","ae","af","bd","be","bf","cd","ce","cf"]` |
| `""`   | `[]` |
| `"2"`  | `["a","b","c"]` |

## Approach

The solution uses **backtracking**. Starting from the first digit, the algorithm picks one letter at a time and recurses to the next digit. Once a combination reaches the full length of the input, it is saved to the result list. Then the algorithm steps back and tries the next letter — hence *backtracking*.

After all combinations are generated, the result is sorted alphabetically using `Collections.sort()`.

**Time complexity:** O(4ⁿ · n) — at most 4 letters per digit, n digits deep  
**Space complexity:** O(n) — recursion depth equals the number of digits

## Project Structure

```
genesys_intern_homework/
├── pom.xml
└── src/
    ├── main/java/com/genesys/
    │   └── PhoneCombinations.java
    └── test/java/com/genesys/
        └── PhoneCombinationsTest.java
```

## Requirements

- Java 21
- Maven 3.8+

## Run Tests

```bash
mvn clean test
```
