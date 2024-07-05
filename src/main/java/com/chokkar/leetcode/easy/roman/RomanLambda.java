package com.chokkar.leetcode.easy.roman;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class RomanLambda {
    public static String intToRoman(int num) {
        // Create a LinkedHashMap of Roman numerals
        LinkedHashMap<String, Integer> romanNumerals = new LinkedHashMap<>();
        romanNumerals.put("M", 1000);
        romanNumerals.put("D", 500);
        romanNumerals.put("C", 100);
        romanNumerals.put("L", 50);
        romanNumerals.put("X", 10);
        romanNumerals.put("V", 5);
        romanNumerals.put("I", 1);

        // StringBuilder to store the Roman numeral
        StringBuilder result = new StringBuilder();
        // Use an array to hold the mutable state of num
        final int[] remainingNum = { num };

        // BiConsumer to handle the addition of Roman numeral symbols
        BiConsumer<String, Integer> appendSymbols = (symbol, value) -> {
            while (remainingNum[0] >= value) {
                result.append(symbol);
                remainingNum[0] -= value;
            }
        };

        // Iterate through the map to construct the Roman numeral
        romanNumerals.forEach((symbol, value) -> {
            if (remainingNum[0] == 0) return;

            // Handle subtractive combinations
            if (symbol.equals("C") && remainingNum[0] >= 90) { // XC
                result.append("XC");
                remainingNum[0] -= 90;
            } else if (symbol.equals("C") && remainingNum[0] >= 40) { // XL
                result.append("XL");
                remainingNum[0] -= 40;
            } else if (symbol.equals("X") && remainingNum[0] >= 9) { // IX
                result.append("IX");
                remainingNum[0] -= 9;
            } else if (symbol.equals("X") && remainingNum[0] >= 4) { // IV
                result.append("IV");
                remainingNum[0] -= 4;
            } else {
                // Use the BiConsumer to append the symbol
                appendSymbols.accept(symbol, value);
            }
        });

        return result.toString();
    }

    public static void main(String[] args) {
        int number = 9;
        String romanNumeral = intToRoman(number);
        System.out.println("Roman numeral for " + number + " is " + romanNumeral);
    }
}
