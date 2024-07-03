package com.chokkar.leetcode.easy.palindrome;

public class Palindrome2 {

    public static void main(String[] args) {

        Palindrome2 palindrome = new Palindrome2();
       boolean isPalindrome =  palindrome.isPalindrome(-121);
        System.out.println(isPalindrome);
    }


    public boolean isPalindrome(int x) {

        String originalValue =  String.valueOf(x);

        StringBuilder stringBuilder = new StringBuilder(originalValue);
        String reversed =  stringBuilder.reverse().toString();

        return originalValue.equals(reversed);
    }
}
