package com.leetcode.integer;

public class SingleNumber136 {

    public int singleNumber(int[] nums) {

        int single = 0;

        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];

        }
        return single;
    }

    public void test() {
        int[] a = new int[] { 4, 4, 1, 1, 2 };

        assert (2 == singleNumber(a));

    }
}
