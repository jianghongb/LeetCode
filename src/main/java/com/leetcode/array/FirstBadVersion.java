package com.leetcode.array;

/**
 *
 */
public class FirstBadVersion {

  /**
   * It is not difficult to see that this could be solved using a classic algorithm - Binary search. Let us see how the search space could be halved each time below.
   *
   * Scenario #1: isBadVersion(mid) => false
   *
   * 1 2 3 4 5 6 7 8 9
   * G G G G G G B B B       G = Good, B = Bad
   * |       |       |
   * left    mid    right
   *
   * Let us look at the first scenario above where isBadVersion(mid)⇒falseisBadVersion(mid) \Rightarrow falseisBadVersion(mid)⇒false. We know that all versions preceding and including midmidmid are all good. So we set left=mid+1left = mid + 1left=mid+1 to indicate that the new search space is the interval [mid+1,right][mid + 1, right][mid+1,right] (inclusive).
   *
   * Scenario #2: isBadVersion(mid) => true
   *
   * 1 2 3 4 5 6 7 8 9
   * G G G B B B B B B       G = Good, B = Bad
   * |       |       |
   * left    mid    right
   *
   * The only scenario left is where isBadVersion(mid)⇒trueisBadVersion(mid) \Rightarrow trueisBadVersion(mid)⇒true. This tells us that midmidmid may or may not be the first bad version, but we can tell for sure that all versions after midmidmid can be discarded. Therefore we set right=midright = midright=mid as the new search space of interval [left,mid][left,mid][left,mid] (inclusive).
   *
   * In our case, we indicate leftleftleft and rightrightright as the boundary of our search space (both inclusive). This is why we initialize left=1left = 1left=1 and right=nright = n right=n. How about the terminating condition? We could guess that leftleftleft and rightrightright eventually both meet and it must be the first bad version, but how could you tell for sure?
   *
   * The formal way is to prove by induction, which you can read up yourself if you are interested. Here is a helpful tip to quickly prove the correctness of your binary search algorithm during an interview. We just need to test an input of size 2. Check if it reduces the search space to a single element (which must be the answer) for both of the scenarios above. If not, your algorithm will never terminate.
   *
   * If you are setting mid=left+right2mid = \frac{left + right}{2}mid=2left+right​, you have to be very careful. Unless you are using a language that does not overflow such as Python, left+rightleft + rightleft+right could overflow. One way to fix this is to use left+right−left2left + \frac{right - left}{2}left+2right−left​ instead.
   *
   * If you fall into this subtle overflow bug, you are not alone. Even Jon Bentley's own implementation of binary search had this overflow bug and remained undetected for over twenty years.
   *
   * @param n
   * @return
   */
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean isBadVersion(int mid) {
    return mid == 4;
  }
}
