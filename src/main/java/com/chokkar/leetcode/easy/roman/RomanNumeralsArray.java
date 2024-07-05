package com.chokkar.leetcode.easy.roman;

public class RomanNumeralsArray {
    public static String intToRoman(int num) {
        // Roman numeral symbols and their values
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // StringBuilder to store the Roman numeral
        StringBuilder result = new StringBuilder();

        // Iterate through each symbol and its value
        for (int i = 0; i < values.length; i++) {
            // Append the symbol while its value is less than or equal to num
            while (num >= values[i]) {
                result.append(romanSymbols[i]);
                num -= values[i];
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
