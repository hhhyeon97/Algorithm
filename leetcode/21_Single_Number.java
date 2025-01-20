
// https://leetcode.com/problems/single-number/description/

import java.util.*;

// 문제 조건 : 선형 시간 복잡도/일정한 추가 공간만 사용

// 풀이 1. XOR 연산

// 배열의 모든 숫자를 XOR로 연산
// 모든 숫자가 두 번씩 나타난다면 XOR 연산 결과가 0이 된다.
// 단일 숫자는 두 번 나타나지 않으므로 최종 결과에 남는다.

class Solution1 {
    public int singleNumber(int[] nums) {
        
        int result = 0;
        
        // 배열의 모든 숫자를 XOR 연산
        for (int num : nums) {
            result ^= num;
        }
        
        return result; // 단일 숫자가 남는다
    }
}

// 풀이 2. 해시맵 활용 접근 

class Solution2 {
    public int singleNumber(int[] nums) {
        
        HashMap<Integer, Integer> count = new HashMap<>();
        
        // 각 숫자 빈도 저장
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // 빈도가 1인 숫자 반환
        for (int key : count.keySet()) {
            if (count.get(key) == 1) {
                return key;
            }
        }
        return -1; // 기본값 -> 문제에서 항상 단일 숫자가 있다고 보장
    }
}