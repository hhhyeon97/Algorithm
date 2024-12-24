
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

/*
주어진 배열 nums는 이미 정렬된 상태임
ㄴ> 중복된 값들이 연속적으로 나온다.

문제 조건이 배열의 앞부분에 고유 값만 올바르게 배치했는지 확인하는 것
배열 전체를 완벽히 정리하는 작업이 아님
ㄴ> 배열의 뒤쪽 값들은 중요하지 않음.
고유한 값들이 배열의 처음부터 차례로 채워졌다면, 반환값으로 고유 값의 개수를 리턴한다.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // 배열이 비었으면 0 반환 (예외 처리)

        int result = 0; // 고유 요소를 저장할 위치 (초기값: 첫 번째 요소 위치)

        // 배열 순회 (i는 현재 비교할 위치)
        // 첫번째 값은 앞에 비교할 숫자가 없으므로 
        // 2번째 값부터 첫번째 값과 비교하기 위해 i=1부터 시작
        for (int i = 1; i < nums.length; i++) {
            // 중복 여부 확인
            if (nums[i] != nums[result]) {
                result++; // 고유 요소 위치 이동
                nums[result] = nums[i]; // 고유 요소 저장
            }
        }
        // 배열 순회가 끝나면
        // result가 마지막 고유 값의 위치(인덱스)를 가리키고 있음.
        // 고유 값의 개수: result + 1 

        return result + 1; // 고유 요소 개수(result는 인덱스이므로 +1)
    }
}