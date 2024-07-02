package com.chokkar.leetcode.easy.twosum;

import java.util.HashMap;

class TwoSumSolution3 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length); // Initialize map with expected size

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumSolution3 solution = new TwoSumSolution3();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        long startTime = System.nanoTime();
        int[] result = solution.twoSum(nums, target);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime); // Duration in nanoseconds
        System.out.println("Execution time: " + duration + " nanoseconds");

        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found");
        }
    }
}
