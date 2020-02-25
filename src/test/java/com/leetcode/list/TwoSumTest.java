package com.leetcode.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.leetcode.array.AddArrayFormInteger989;
import com.leetcode.array.RemoveElement27;
import com.leetcode.array.TwoSum1;

public class TwoSumTest {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(List<Integer> nums) {

        String result = "";
        for (int index = 0; index < nums.size(); index++) {
            Integer number = nums.get(index);
            result += number + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            List<Integer> ret = new AddArrayFormInteger989().addToArrayForm(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
