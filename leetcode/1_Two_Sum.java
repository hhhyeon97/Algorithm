
// https://leetcode.com/problems/two-sum/description/
/*
 * 해시맵을 사용하여 각 숫자의 인덱스를 저장한다.
배열을 순회하면서 target에서 현재 숫자를 뺀 값(차이값)이 해시맵에 존재하는지 확인한다.
만약 존재하면 그 값의 인덱스와 현재 인덱스를 반환한다.
존재하지 않으면 현재 숫자를 해시맵에 추가하여 이후 탐색에 사용할 수 있도록 한다.
ㄴ> 시간 복잡도는 **O(n)**이다. 
ㄴ> 모든 숫자를 한 번만 순회하면 되기 때문에 효율적이다.
 * 
 */
package leetcode;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            
            // 해시맵에 차이값이 있는지 확인
            if (map.containsKey(difference)) {
                return new int[] { map.get(difference), i };
            }
            
            // 현재 숫자와 인덱스를 해시맵에 저장
            map.put(nums[i], i);
        }
        
        // 문제 조건상 항상 답이 하나만 존재함 -> 이 부분은 실행되지 않음
        return new int[] {};
    }
}