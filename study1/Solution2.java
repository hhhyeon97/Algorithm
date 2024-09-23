import java.util.*;
// LeetCode 2824. Count Pairs Whose Sum is Less than Target
// 합이 목표보다 작은 쌍의 개수 계산


// import java.util.List;
// import java.util.ArrayList;

class Solution1 {
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;  // 조건을 만족하는 쌍의 개수를 저장할 변수

        // 이중 for문을 사용하여 리스트의 모든 가능한 쌍 확인
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                // 쌍의 합이 target보다 작은지 확인
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        
        return count; 
    }
}

// 다른 풀이
/*
효율적인 방법: 투 포인터 알고리즘
리스트를 오름차순으로 정렬
투 포인터를 사용하여 리스트의 처음과 끝에서부터 이동하며 조건을 만족하는 쌍의 개수 세기
*/
    
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Collections;

class Solution2 {
    public int countPairs(List<Integer> nums, int target) {
        // 리스트를 정렬
        Collections.sort(nums);

        int count = 0;
        int left = 0;
        int right = nums.size() - 1;

        // 투 포인터를 사용하여 쌍의 개수 세기
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                // 조건을 만족하는 쌍의 개수를 계산
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        
        return count;
    }
}