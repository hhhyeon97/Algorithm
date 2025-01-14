
// https://leetcode.com/problems/intersection-of-two-arrays/description/

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        // 두 배열 정렬
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        Set<Integer> resultSet = new HashSet<>();

        // 두 배열을 투 포인터로 순회하며 교집합 찾기
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultSet.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // 결과 집합을 배열로 변환
        int[] result = new int[resultSet.size()];
        int k = 0;
        for (int num : resultSet) {
            result[k++] = num;
        }

        return result;
    }
}