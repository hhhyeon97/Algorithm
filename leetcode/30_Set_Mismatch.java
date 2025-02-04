
// https://leetcode.com/problems/set-mismatch/description/

/*
문제 접근
중복된 숫자 찾기 -> 같은 숫자가 두 번 등장하면 저장
빠진 숫자 찾기 -> 1~n 돌면서 Set 이용해 없는 숫자 찾기
*/

import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        
        // nums 배열 길이
        int n = nums.length;
        
        // 중복된 요소, 없는 요소
        int duplicate = -1, missing = -1;
        
        Set<Integer> seen = new HashSet<>();

        // 중복된 숫자 찾기
        for (int num : nums) {
            if (seen.contains(num)) {
                duplicate = num;
            }
            seen.add(num);
        }

        // 빠진 숫자 찾기
        for (int i = 1; i <= n; i++) {
            if (!seen.contains(i)) {
                missing = i;
                break;
            }
        }

        // 최종 결과 반환
        return new int[]{duplicate, missing};
    }
}
