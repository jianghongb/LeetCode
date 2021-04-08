package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 *
 * 599. Minimum Index Sum of Two Lists
 * Easy
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 *
 *
 *
 * Example 1:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 *
 * Example 2:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 *
 * Example 3:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Burger King","Tapioca Express","Shogun"]
 * Output: ["KFC","Burger King","Tapioca Express","Shogun"]
 *
 * Example 4:
 *
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KNN","KFC","Burger King","Tapioca Express","Shogun"]
 * Output: ["KFC","Burger King","Tapioca Express","Shogun"]
 *
 * Example 5:
 *
 * Input: list1 = ["KFC"], list2 = ["KFC"]
 * Output: ["KFC"]
 *
 *
 *
 * Constraints:
 *
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] and list2[i] consist of spaces ' ' and English letters.
 * All the stings of list1 are unique.
 * All the stings of list2 are unique.
 */
public class MinimumIndexSumofTwoLists {

  public static String[] findRestaurant(String[] list1, String[] list2) {

    if (null == list1 || null == list2) {
      return null;
    }
    int min = Integer.MAX_VALUE;
    List<String> value = new ArrayList<>();
    Map<String, Integer> result = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      result.put(list1[i], i);
    }
    for (int i = 0; i < list2.length; i++) {
      if (result.get(list2[i]) != null) {
        int sum = result.get(list2[i]) + i;
        if (min > sum) {
          min = sum;
          value.clear();
          value.add(list2[i]);
        } else if (min == sum) {
          value.add(list2[i]);
        }
      }

    }
    return value.toArray(new String[value.size()]);
  }

  public static void main(String[] args) {
    String[] list1 = {
        "Shogun", "Tapioca Express", "Burger King", "KFC"
    };
    String[] list2 = { "KNN", "KFC", "Burger King", "Tapioca Express", "Shogun" };

    String[] restaurant = findRestaurant(list1,
        list2);
    Arrays.stream(restaurant).forEach(System.out::println);
  }

}
