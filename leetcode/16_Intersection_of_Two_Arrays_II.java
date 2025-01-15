
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        // 첫 번째 배열의 숫자/빈도 기록
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // 교차 결과 저장할 리스트
        List<Integer> resultList = new ArrayList<>();

        for (int num : nums2) {
            // nums2의 숫자가 countMap에 있고, 빈도가 남아 있다면
            if (countMap.getOrDefault(num, 0) > 0) {
                resultList.add(num); // 1. 결과 리스트에 추가
                countMap.put(num, countMap.get(num) - 1); // 2. 빈도를 감소
            }
        }
        // ex )
        // nums1 = [1,2,2,1]인 경우 countMap은 {1=2, 2=2}
        // nums2 = [2, 2];
        // 결과 : resultList = [2, 2];

        // 리스트 → 배열로 변환
        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}