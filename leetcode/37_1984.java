
// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/

package leetcode;

import java.util.*;

class Solution {
    public int minimumDifference(int[] nums, int k) {
       
       // 정렬 한 뒤 연속된 k개의 범위 중 최소 차이 찾기
       
       Arrays.sort(nums);  // 오름차순 정렬
       
       // 최소값 담을 변수
       int minDiff = Integer.MAX_VALUE;
       
       // 정렬하면 인접한 숫자끼리의 차이가 가장 작게 됨!!
       // 연속된 k개의 요소 중 최댓값 - 최솟값이 가장 작은 구간을 찾는다!
       for (int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
}