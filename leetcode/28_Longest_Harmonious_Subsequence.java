
// https://leetcode.com/problems/longest-harmonious-subsequence/description/


// 문제 접근
// 각 숫자 빈도 저장 -> 인접한 숫자의 빈도 더해서 가장 긴 부분 수열 길이 찾기
// ㄴ nums[i]가 있으면 nums[i]+1도 있는 경우의 합 찾기

import java.util.*;

class Solution {
    public int findLHS(int[] nums) {

        // ex ) nums = {1, 3, 2, 2, 5, 2, 3, 7}

        Map<Integer, Integer> map = new HashMap<>();
        
        // 숫자의 빈도를 저장
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // map = {1=1, 2=3, 3=2, 5=1, 7=1}

        int maxLength = 0;
        
        // 인접한 두 수의 빈도 합 중 최대값 찾기
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) { // key+1이 존재하는 경우만 고려
                maxLength = Math.max(maxLength, map.get(key) + map.get(key + 1)); // 최대값 갱신
            }
        }
        /*
        key = 1일 때 -> 인접한 (key+1)인 2 존재 -> 1(key 1의 값 1) + 3(key+1인 2의 값은 3) = 4 -> maxLength = 4
        key = 2	-> 3 존재 -> 3 + 2 = 5 -> maxLength = 5
        key = 3일 때 key+1인 4 없음 / key = 5, key = 7도 마찬가지
        
        그럼 최종 maxLength은 5
        */
        
        return maxLength;
    }
}