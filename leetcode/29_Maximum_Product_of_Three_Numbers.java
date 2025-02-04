
// https://leetcode.com/problems/maximum-product-of-three-numbers/description/

import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {

        // 오름차순 정렬
        Arrays.sort(nums);
        
        // nums 배열 길이
        int n = nums.length;
        
        // 음수가 있는 경우도 고려해야 함
        // 음수 두 개를 곱하면 양수가 되니까
        // 가장 큰 양수 3개를 곱하는 것보다 
        // 작은 음수 2개와 가장 큰 양수를 곱하는 경우가 더 클 수도 있음
        // 1. 가장 큰 양수 3개
        // 2. 가장 작은 음수 2개와 가장 큰 양수 
        // 두 값 중 더 큰 값을 리턴
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], 
                        nums[0] * nums[1] * nums[n - 1]);
    }
}