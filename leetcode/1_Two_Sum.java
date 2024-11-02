
// https://leetcode.com/problems/two-sum/description/
/*
 * 해시맵을 사용하여 각 숫자의 인덱스를 저장한다.
배열을 순회하면서 target에서 현재 숫자를 뺀 값(차이값)이 해시맵에 존재하는지 확인한다.
만약 존재하면 그 값의 인덱스와 현재 인덱스를 반환한다.
존재하지 않으면 현재 숫자를 해시맵에 추가하여 이후 탐색에 사용할 수 있도록 한다.
ㄴ> 시간 복잡도는 O(n)이다. 
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

/*
ex ) 

입력:
nums = [2, 7, 11, 15]
target = 9

- 초기 상태: map = {} (빈 해시맵)

- 첫 번째 숫자 nums[0] = 2 (인덱스 0):
difference = target - nums[0] = 9 - 2 = 7
해시맵에 7이 있는지 확인 (현재 map에는 아무것도 없음).
7이 없으므로, 해시맵에 현재 숫자 2와 인덱스 0을 저장.
업데이트된 map = {2: 0}

- 두 번째 숫자 nums[1] = 7 (인덱스 1):
difference = target - nums[1] = 9 - 7 = 2
해시맵에 2가 있는지 확인 (현재 map = {2: 0}).
2가 해시맵에 존재하고, 그 인덱스가 0이다.
ㄴ> map.get(difference) = 0이고, 현재 인덱스 1과 함께 [0, 1]을 반환.
결과: [0, 1]
*/