
// https://leetcode.com/problems/array-partition/description/

// 접근
// 오름차순으로 정렬
// 짝수 인덱스에 위치한 값들만 합해서 최대값 구하기

import java.util.*;

class Solution {
    public int arrayPairSum(int[] nums) {
        
        // 오름차순 정렬
        Arrays.sort(nums); 

        int sum = 0;
        
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i]; // 짝수 인덱스 값 더하기
        }
        
        return sum;
    }
}