
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // 빈 배열 처리

        int result = 0; // 고유 요소를 저장할 위치

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[result]) {
                result++; // 고유 요소의 위치 증가
                nums[result] = nums[i]; // 고유 요소 저장
            }
        }
        return result + 1; // 고유 요소 개수
    }
}