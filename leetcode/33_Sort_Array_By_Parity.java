
// https://leetcode.com/problems/sort-array-by-parity/description/

// 투 포인터 사용
// O(N): right가 배열을 한 번만 순회
// O(1): 추가 메모리 없이 제자리 정렬 (in-place)
// 결과 배열 순서가 여러 개 가능하므로 문제 조건 만족함

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 0) { // 짝수라면
                // 교체
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; // 다음 짝수 위치로 이동
            }
        }
        
        return nums;
    }
}
