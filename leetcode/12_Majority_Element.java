
// https://leetcode.com/problems/majority-element/description/

// 조건
// 배열의 크기를 n이라 하면, 다수 원소는 n / 2 보다 많이 나타나야 한다.
// 항상 다수 원소가 존재한다고 가정.

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        
        // 해시맵으로 빈도 카운팅
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int majorityCount = nums.length / 2;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if (countMap.get(num) > majorityCount) {
                return num;
            }
        }

        // 이 문제에선 항상 다수 원소가 존재하므로 실제로 도달하지 않음
        return -1; 

        // 방법2. 정렬
        // Arrays.sort(nums);
        // return nums[nums.length / 2];
    }
}