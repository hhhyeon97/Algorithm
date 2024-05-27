// LeetCode 2824. Count Pairs Whose Sum is Less than Target
// 합이 목표보다 작은 쌍의 개수 계산


import java.util.List;
import java.util.ArrayList;

public class Solution {
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
