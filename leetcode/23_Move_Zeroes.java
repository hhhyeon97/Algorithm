
// https://leetcode.com/problems/move-zeroes/description/

class Solution {
    public void moveZeroes(int[] nums) {
        
        int j = 0; // 0이 아닌 값을 채워넣을 위치
        
        // 1. 0이 아닌 값을 앞으로 이동
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i]; // 비 0 값을 복사
                j++;               // 채워넣을 위치 증가
            }
        }

        // 2. 나머지 자리를 0으로 채움
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}