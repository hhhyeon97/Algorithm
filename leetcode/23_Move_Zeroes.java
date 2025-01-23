
// https://leetcode.com/problems/move-zeroes/description/

class Solution {
    public void moveZeroes(int[] nums) {
        
        // ex ) nums = [0, 1, 0, 3, 12]

        int j = 0; // 0이 아닌 값을 채워넣을 위치 -> (0이 아닌 값을 채울 인덱스)
        
        // 1. 0이 아닌 값을 앞으로 이동
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i]; // 비 0 값을 복사
                j++;               // 채워넣을 위치 증가
            }
        }
        /* ex ) 
        0이 아닌 숫자들을 앞으로 덮어 쓰면서 이동한다.

        초기 상태: nums = [0, 1, 0, 3, 12], j = 0

        1. 첫 번째 반복 (i = 0)
        nums[0] = 0 → 0이므로 아무 작업도 하지 않고 건너뜀.
        현재 상태:
        nums = [0, 1, 0, 3, 12]
        j = 0

        2. 두 번째 반복 (i = 1)
        nums[1] = 1 → 0이 아님.
        nums[j] = nums[i] 수행: nums[0] = nums[1] → 1을 0번째 위치로 덮어씀.
        j 증가: j = 1.
        현재 상태:
        nums = [1, 1, 0, 3, 12]
        j = 1

        3. 세 번째 반복 (i = 2)
        nums[2] = 0 → 0이므로 아무 작업도 하지 않고 건너뜀.
        현재 상태:
        nums = [1, 1, 0, 3, 12]
        j = 1

        4. 네 번째 반복 (i = 3)
        nums[3] = 3 → 0이 아님.
        nums[j] = nums[i] 수행: nums[1] = nums[3] → 3을 1번째 위치로 덮어씀.
        j 증가: j = 2.
        현재 상태:
        nums = [1, 3, 0, 3, 12]
        j = 2

        5. 다섯 번째 반복 (i = 4)
        nums[4] = 12 → 0이 아님.
        nums[j] = nums[i] 수행: nums[2] = nums[4] → 12를 2번째 위치로 덮어씀.
        j 증가: j = 3.
        현재 상태:
        nums = [1, 3, 12, 3, 12]
        j = 3
        */

        // 2. 나머지 자리를 0으로 채움
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        /*
        i = 3: nums[3] = 0
        i = 4: nums[4] = 0
        최종 결과: nums = [1, 3, 12, 0, 0]
        */
    }
}