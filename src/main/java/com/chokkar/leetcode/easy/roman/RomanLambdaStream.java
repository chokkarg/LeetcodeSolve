package com.chokkar.leetcode.easy.roman;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanLambdaStream {
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

        // Array to hold the remaining number, as we need to modify it within the stream
        final int[] remainingNum = { num };

        // Convert each entry to the appropriate number of Roman numeral symbols
        return romanNumerals.entrySet().stream()
                .flatMap(entry -> {
                    String symbol = entry.getKey();
                    int value = entry.getValue();
                    int count = 0;

                    // Handle subtractive combinations
                    if (symbol.equals("C") && remainingNum[0] >= 90) { // XC
                        count = 1;
                        remainingNum[0] -= 90;
                        return IntStream.range(0, count).mapToObj(i -> "XC");
                    } else if (symbol.equals("C") && remainingNum[0] >= 40) { // XL
                        count = 1;
                        remainingNum[0] -= 40;
                        return IntStream.range(0, count).mapToObj(i -> "XL");
                    } else if (symbol.equals("X") && remainingNum[0] >= 9) { // IX
                        count = 1;
                        remainingNum[0] -= 9;
                        return IntStream.range(0, count).mapToObj(i -> "IX");
                    } else if (symbol.equals("X") && remainingNum[0] >= 4) { // IV
                        count = 1;
                        remainingNum[0] -= 4;
                        return IntStream.range(0, count).mapToObj(i -> "IV");
                    } else {
                        count = remainingNum[0] / value;
                        remainingNum[0] %= value;
                        return IntStream.range(0, count).mapToObj(i -> symbol);
                    }
                })
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        int number = 9;
        String romanNumeral = intToRoman(number);
        System.out.println("Roman numeral for " + number + " is " + romanNumeral);
    }
}
