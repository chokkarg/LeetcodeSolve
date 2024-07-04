package com.chokkar.leetcode.easy.palindrome;

public class Palindrome3 {

    public static void main(String[] args) {

        int a = 121;
        Palindrome3 palidrome1 = new Palindrome3();
        boolean isPalindrome = palidrome1.isPalindrome(a);
        System.out.println("is Palindrome " + isPalindrome);
    }

    public boolean isPalindrome(int x) {

        int originalValue = x;
        int reversedValue = 0;
        int temp;

        while( x != 0 ) {
            temp = x % 10;
            reversedValue = reversedValue * 10 + temp;
            x = x / 10;
        }
        if(originalValue == reversedValue) {
            return true;
        }
        return false;
    }
}
