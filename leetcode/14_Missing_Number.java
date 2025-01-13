
// https://leetcode.com/problems/missing-number/description/

import java.util.Arrays;
class Solution {
    public int missingNumber(int[] nums) {
        // 배열 정렬
        Arrays.sort(nums);

        // 0부터 n까지 숫자가 맞는지 확인
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i; // i와 nums[i]가 다르면 누락된 숫자
            }
        }

        // 끝까지 다 확인했으면 마지막 숫자 n이 누락된 숫자
        return nums.length;
    }
}