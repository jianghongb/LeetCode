package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionArrays350 {

  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
      return null;
    }

    //int length = nums1.length > nums2.length ? nums1.length : nums2.length;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
    }
    int k = 0;
    for (int i = 0; i < nums2.length; i++) {
      if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
        nums1[k] = nums2[i];
        k++;
      }
      map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
    }
    return Arrays.copyOfRange(nums1, 0, k);

  }

  public int[] intersection(int[] nums1, int[] nums2) {

    if(nums1 ==null || nums1.length ==0|| nums2 == null || nums2.length == 0){
      return new int[]{};
    }

    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    for(int i =0;i < nums1.length;i++){
      set1.add(nums1[i]);
    }
    for(int i = 0;i< nums2.length;i++){
      if(set1.contains(nums2[i])){
        set2.add(nums2[i]);
      }
    }

    int[] result =  new int[set2.size()];
    int index =0;
    for (int i: set2 ) {
      result[index++] = i;
    }
    return result;
  }
}
