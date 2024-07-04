package com.chokkar.leetcode.easy.palindrome;

public class Palindrome1 {

    public static void main(String[] args) {

        int a = 121;
        Palindrome1 palidrome1 = new Palindrome1();
        boolean isPalindrome = palidrome1.isPalindrome(a);
        System.out.println("is Palindrome " + isPalindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int originalValue = x;
        int reversedValue = 0;

        while (x != 0) {
            int lastDigit = x % 10;

            // Check for overflow
            if (reversedValue > (Integer.MAX_VALUE - lastDigit) / 10) {
                return false;
            }

            reversedValue = reversedValue * 10 + lastDigit;
            x = x / 10;
        }

        return originalValue == reversedValue;
    }


}
