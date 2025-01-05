
// https://leetcode.com/problems/remove-element/description/

// 배열에서 특정 값 제거 후 나머지 요소의 개수를 반환한다.
// 배열을 제자리(in-place)에서 수정해야 함 
class Solution {
    public int removeElement(int[] nums, int val) {

        int i = 0; // 첫 번째 포인터
        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j]; // 값 복사
                i++; // 포인터 이동
            }
        }
        
        return i; // 남은 요소의 개수 반환
    }
}