package com.chokkar.leetcode.easy.twosum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

class TwoSumSolution4 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        Optional<int[]> result = IntStream.range(0, nums.length)
                .mapToObj(i -> {
                    int complement = target - nums[i];
                    if (map.containsKey(complement)) {
                        return new int[]{map.get(complement), i};
                    }
                    map.put(nums[i], i);
                    return null;
                })
                .filter(x -> x != null)
                .findFirst();

        return result.orElse(new int[]{});
    }

    public static void main(String[] args) {
        TwoSumSolution4 solution = new TwoSumSolution4();
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
