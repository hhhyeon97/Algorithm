
// https://leetcode.com/problems/longest-harmonious-subsequence/description/


// 문제 접근
// 각 숫자 빈도 저장 -> 인접한 숫자의 빈도 더해서 가장 큰 값 찾기
// ㄴ nums[i]가 있으면 nums[i]+1도 있는 경우의 합 찾기

import java.util.*;

class Solution {
    public int findLHS(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        
        // 숫자의 빈도를 저장
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        
        // 인접한 두 수의 빈도 합 중 최대값 찾기
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) { // key+1이 존재하는 경우만 고려
                maxLength = Math.max(maxLength, map.get(key) + map.get(key + 1)); // 최대값 갱신
            }
        }
        
        return maxLength;
    }
}