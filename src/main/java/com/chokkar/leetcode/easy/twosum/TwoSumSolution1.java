package com.chokkar.leetcode.easy.twosum;

import java.util.HashMap;

public class TwoSumSolution1 {

    public static void main(String[] args) {

//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;

        int[] nums = new int[]{3,2,4};
        int target = 6;

        TwoSumSolution1 twoSum = new TwoSumSolution1();
        twoSum.twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> twoSumValues = new HashMap<Integer, Integer>();

        for (int i=0;i< nums.length; i++) {
            twoSumValues.put(i, nums[i]);
        }

        for (int i = 0; i <twoSumValues.entrySet().size(); i++) {
             twoSumValues.get(i);
            for (int j = i+1; j < twoSumValues.entrySet().size(); j++) {
                   if(twoSumValues.get(i) + twoSumValues.get(j) == target )
                   {
                       System.out.println("Found target value " +  twoSumValues.get(i) + " " +twoSumValues.get(j) );

                       break;
                   }
            }
        }



        return nums;
    }

}
