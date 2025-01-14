
// https://leetcode.com/problems/intersection-of-two-arrays/description/

// 두 배열의 교집합 구하기

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        // 방법 1. 정렬 활용 
        
        // // 두 배열 정렬
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);

        // int i = 0, j = 0;
        // Set<Integer> resultSet = new HashSet<>();

        // // 두 배열을 투 포인터로 순회하며 교집합 찾기
        // while (i < nums1.length && j < nums2.length) {
        //     if (nums1[i] == nums2[j]) {
        //         resultSet.add(nums1[i]);
        //         i++;
        //         j++;
        //     } else if (nums1[i] < nums2[j]) {
        //         i++;
        //     } else {
        //         j++;
        //     }
        // }

        // // 결과 집합을 배열로 변환
        // int[] result = new int[resultSet.size()];
        // int k = 0;
        // for (int num : resultSet) {
        //     result[k++] = num;
        // }

        // return result;

        // 방법 2. 해시셋 활용

        // nums1의 요소를 HashSet에 추가
        Set<Integer> set1 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
 
        // nums2의 요소를 순회하며 교집합 찾기
        Set<Integer> resultSet = new HashSet<>();
        
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num); // 교집합에 추가
            }
        }
 
        // 결과 집합을 배열로 변환
        int[] result = new int[resultSet.size()];

        int i = 0;
        
        for (int num : resultSet) {
            result[i++] = num;
        }
 
        return result;
    }
}