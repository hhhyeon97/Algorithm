
// https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/

// 문제 접근
// 배열에서 최댓값 찾기
// 최댓값이 다른 모든!! 원소의 두 배 이상인가 확인
// 만족하는 값의 인덱스 혹은 -1 반환

class Solution {
    public int dominantIndex(int[] nums) {
        
        int maxIndex = 0;
        int maxValue = nums[0];
        
        // 1. 최댓값과 그 인덱스 찾기
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        
        // 2. 최댓값이 다른 원소의 두 배 이상인지 확인
        for (int num : nums) {
            if (num != maxValue && maxValue < 2 * num) {
                return -1;
            }
        }
        
        // 3. 조건 만족 시 인덱스 반환
        return maxIndex;
    }
}