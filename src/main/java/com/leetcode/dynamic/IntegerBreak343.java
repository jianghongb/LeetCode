package com.leetcode.dynamic;

/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 *
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 *
 *
 * Constraints:
 *
 * 2 <= n <= 58
 */
public class IntegerBreak343 {

  /**
   * 动规五部曲，分析如下：
   *
   *     确定dp数组（dp table）以及下标的含义
   *
   * dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
   *
   * dp[i]的定义讲贯彻整个解题过程，下面哪一步想不懂了，就想想dp[i]究竟表示的是啥！
   *
   *     确定递推公式
   *
   * 可以想 dp[i]最大乘积是怎么得到的呢？
   *
   * 其实可以从1遍历j，然后有两种渠道得到dp[i].
   *
   * 一个是j * (i - j) 直接相乘。
   *
   * 一个是j * dp[i - j]，相当于是拆分(i - j)，对这个拆分不理解的话，可以回想dp数组的定义。
   *
   * 那有同学问了，j怎么就不拆分呢？
   *
   * j是从1开始遍历，拆分j的情况，在遍历j的过程中其实都计算过了。
   *
   * 那么从1遍历j，比较(i - j) * j和dp[i - j] * j 取最大的。
   *
   * 递推公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
   *
   *     dp的初始化
   *
   * 不少同学应该疑惑，dp[0] dp[1]应该初始化多少呢？
   *
   * 有的题解里会给出dp[0] = 1，dp[1] = 1的初始化，但解释比较牵强，主要还是因为这么初始化可以把题目过了。
   *
   * 严格从dp[i]的定义来说，dp[0] dp[1] 就不应该初始化，也就是没有意义的数值。
   *
   * 拆分0和拆分1的最大乘积是多少？
   *
   * 这是无解的。
   *
   * 这里我只初始化dp[2] = 1，从dp[i]的定义来说，拆分数字2，得到的最大乘积是1，这个没有任何异议！
   *
   *     确定遍历顺序
   *
   * 确定遍历顺序，先来看看递归公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
   *
   * dp[i] 是依靠 dp[i - j]的状态，所以遍历i一定是从前向后遍历，先有dp[i - j]再有dp[i]。
   *
   * 枚举j的时候，是从1开始的。i是从3开始，这样dp[i - j]就是dp[2]正好可以通过我们初始化的数值求出来。
   *
   * 所以遍历顺序为：
   *
   * for (int i = 3; i <= n ; i++) {
   *     for (int j = 1; j < i - 1; j++) {
   *         dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
   *     }
   * }
   *
   *     举例推导dp数组
   *
   * 举例当n为10 的时候，dp数组里的数值，如下：
   *  2 3 4 5 6  7  8  9 10
   *  1 2 4 6 9 12 18 27 36
   *
   * @param n
   * @return
   */
  public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      for (int j = 1; j < i - 1; j++) {
        dp[i] = Math.max(dp[i], Math.max((i - j) * j, j * dp[i - j]));
      }
    }
    return dp[n];
  }
}
