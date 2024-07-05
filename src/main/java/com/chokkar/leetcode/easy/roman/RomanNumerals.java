package com.chokkar.leetcode.easy.roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {
    public static String intToRoman(int num) {
        // Step 1: Create a LinkedHashMap of Roman numerals in descending order
        LinkedHashMap<String, Integer> romanNumerals = new LinkedHashMap<>();
        romanNumerals.put("M", 1000);
        romanNumerals.put("D", 500);
        romanNumerals.put("C", 100);
        romanNumerals.put("L", 50);
        romanNumerals.put("X", 10);
        romanNumerals.put("V", 5);
        romanNumerals.put("I", 1);

        // Step 2: Iterate through the map to construct the Roman numeral
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : romanNumerals.entrySet()) {
            while (num >= entry.getValue()) {
                result.append(entry.getKey());
                num -= entry.getValue();
            }
        }

        // Handle subtractive combinations
            return result.toString().replace("DCCCC", "CM")
                    .replace("CCCC", "CD")
                    .replace("LXXXX", "XC")
                    .replace("XXXX", "XL")
                    .replace("VIIII", "IX")
                    .replace("IIII", "IV");
    }

    public static void main(String[] args) {
        int number = 9;
        String romanNumeral = intToRoman(number);
        System.out.println("Roman numeral for " + number + " is " + romanNumeral);
    }
}
