
// https://leetcode.com/problems/contains-duplicate/description/

// 해시셋은 중복 허용 안 하는 자료구조!
// 배열 요소를 해시셋에 하나씩 넣으면서
// 이미 존재하는 요소를 추가하려고 하면
// true를 반환해보자

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) { // 이미 존재하면 중복
                return true;
            }
            set.add(num); // 새로운 값 추가
        }
        
        return false; // 중복 없음
    }
}