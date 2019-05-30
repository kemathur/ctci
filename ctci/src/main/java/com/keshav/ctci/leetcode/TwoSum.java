package com.keshav.ctci.leetcode;

import com.keshav.ctci.hash.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i=0; i<n ; i++) {
            map.put(nums[i], i);
        }
        for (int i=0; i<n ; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null && i!= j) {
                return new int[] {i, j};
            }
        }
        return null;
    }
}