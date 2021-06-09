package com.leetcode.array;

public class RotateArray {
	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
		int k = 3;
		rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.exit(0);

	}

	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;
		k %= nums.length;
		rotate_nums(nums, 0, nums.length - k - 1);
		rotate_nums(nums, nums.length - k, nums.length - 1);
		rotate_nums(nums, 0, nums.length - 1);

	}

	public static void rotate_nums(int[] nums, int from, int to) {
		while (from < to) {
			int temp = nums[from];
			nums[from] = nums[to];
			nums[to] = temp;
			from++;
			to--;
		}
	}

	public static void rotate_timeout(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return;
		if (nums.length < k) {
			k = k % nums.length;
		}
		for (int i = 0; i < k; i++) {
			int lastNum = nums[nums.length - 1];
			for (int j = 1; j <= nums.length && nums.length - j > 0; j++) {
				int length_j = nums.length - j;
				int length_j_1 = nums.length - j - 1;
				nums[length_j] = nums[length_j_1];
			}
			nums[0] = lastNum;
		}
	}

}
