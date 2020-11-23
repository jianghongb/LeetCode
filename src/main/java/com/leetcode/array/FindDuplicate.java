package com.leetcode.array;

/**
 * 查找数组中重复数字：
 * 解题思路一： 时间复杂度O(nlogn)
 *  将数组排序，然后从头到尾扫描排序后的数组即可
 * 解题思路二： 空间复杂度O(n) 时间复杂度O(n)
 *  扫描数组每一个值，每扫描一个数字的时候都用O(1)判断hash表里是不是包含该数字，如果没有就加入到hash表，如果有就找到了重复数字。
 *
 * 解题思路三：时间复杂度最大为O(n),空间复杂度O(1)
 *  从头开始扫描数组，当扫描到下标为i的数字时，首先比较当前位置数字m=nums[i]是不是等于i，如果相等则继续；
 *  否则，取出以m为下标的数字j=nums[m],如果m==j,则找到了重复数字；如果不相等，则交换m 和j的值，重复上述过程，直到结束
 *
 */
public class FindDuplicate {

  public boolean duplicate(int[] nums) {
    if (null == nums || nums.length == 0) {
      return false;
    }

    for (int i = 0; i < nums.length - 1; i++) {
      int m = nums[i];
      if (i != m) {
        int j = nums[m];
        if (m == j) {
          return true;
        } else {
          int tmp = m;
          nums[i] = j;
          nums[m] = tmp;
        }
      }
    }
    return false;
  }
}
