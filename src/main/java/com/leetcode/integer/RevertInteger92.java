package com.leetcode.integer;

public class RevertInteger92 {
	public static int convert(int num) {
		int result = 0;

		if (num == 0) {
			return result;
		}

		int sign = num / Math.abs(num);
		num *= sign;

		while (num > 0) {
			int i = num % 10;
			num = num / 10;

			result = result * 10 + i;

		}

		return result * sign;
	}

	public int myReserve(int oriNum) {
		int tempNum = oriNum, count, result = 0;
		for (count = 0; tempNum > 0; tempNum /= 10, count++)
			;

		while (oriNum > 0) {
			int num = oriNum % 10;
			for (int i = 1; i < count; i++) {
				num *= 10;
			}
			count--;
			result += num;
			oriNum /= 10;
		}
		;
		return result;
	}

}
