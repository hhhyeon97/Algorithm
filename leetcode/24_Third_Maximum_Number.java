
// https://leetcode.com/problems/third-maximum-number/description/

import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        
        // 중복 없애기 위해 set 구조 사용!
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num); // 중복 제거
        }
        
        List<Integer> sortedList = new ArrayList<>(set);
        
        // 내림차순 정렬
        sortedList.sort(Collections.reverseOrder()); 

        return sortedList.size() >= 3 ? sortedList.get(2) : sortedList.get(0);
    }
}
