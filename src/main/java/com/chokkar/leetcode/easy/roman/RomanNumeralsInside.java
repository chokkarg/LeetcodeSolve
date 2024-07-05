package com.chokkar.leetcode.easy.roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralsInside {
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

        // Iterate through the map to construct the Roman numeral
        for (Map.Entry<String, Integer> entry : romanNumerals.entrySet()) {
            String symbol = entry.getKey();
            int value = entry.getValue();

            // Handle subtractive combinations
            if (num >= value) {
                int count = num / value; // Determine how many times the symbol can be appended
                num %= value; // Update num
                for (int i = 0; i < count; i++) {
                    result.append(symbol);
                }
            }

            // Check for subtractive combinations
            if (symbol.equals("C") && num >= 90) { // XC
                result.append("XC");
                num -= 90;
            } else if (symbol.equals("C") && num >= 40) { // XL
                result.append("XL");
                num -= 40;
            } else if (symbol.equals("X") && num >= 9) { // IX
                result.append("IX");
                num -= 9;
            } else if (symbol.equals("X") && num >= 4) { // IV
                result.append("IV");
                num -= 4;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int number = 9;
        String romanNumeral = intToRoman(number);
        System.out.println("Roman numeral for " + number + " is " + romanNumeral);
    }
}
