package com.chokkar.leetcode.easy.twosum;

public class TwoSumSolution2 {


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;

        TwoSumSolution2 twoSumWithArray = new TwoSumSolution2();
        int[] twoValues =  twoSumWithArray.twoSum(nums, target);
        for (int i = 0; i < twoValues.length; i++) {
            System.out.println(" Two values " + twoValues[i]);
        }
    }


    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    System.out.println("Found value " + nums[i] + " " + nums[j]);
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

}
