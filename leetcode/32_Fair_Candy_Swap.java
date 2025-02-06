
// https://leetcode.com/problems/fair-candy-swap/description/


// 문제 이해
// 베프이므로 사탕 한 번 교환해서 사탕 총량 같게 만들기

import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        
        // 앨리스 총 사탕 개수, 밥 총 사탕 개수
        int sumA = 0, sumB = 0;

        Set<Integer> aliceSet = new HashSet<>();
        
        // 1. 앨리스와 밥의 사탕 총합 계산 & 앨리스 사탕을 해시셋에 저장
        for (int candy : aliceSizes) {
            sumA += candy;
            aliceSet.add(candy);
        }
        for (int candy : bobSizes) {
            sumB += candy;
        }
        
        // 2. 필요한 차이값 계산
        int delta = (sumA - sumB) / 2;  // A - B = (sumA - sumB) / 2
        
        // 3. 밥의 사탕을 하나씩 보면서 
        // 앨리스가 필요한 사탕을 가지고 있는지 확인
        for (int B : bobSizes) {
            int A = B + delta;
            if (aliceSet.contains(A)) {
                return new int[]{A, B};  // 앨리스는 A를 주고, 밥은 B를 줌
            }
        }
        
        return new int[]{-1, -1};  // 문제에서 보장된 조건이므로 실행되지 않음
    }
}
/*
해시셋 사용 이유

ㄴ 1. 앨리스가 가지고 있는 사탕 중 특정 값을 빠르게 찾기 위해

밥의 사탕 B를 보면서 앨리스가 B + delta를 가지고 있는지 찾는 과정이 필요한데
배열에서 찾으면 O(N) 시간이 걸리지만,
해시셋에 넣어두면 O(1)로 바로 찾을 수 있음

ㄴ 2. 시간 복잡도를 줄이기 위해

배열을 이용하면 밥의 사탕마다 앨리스의 사탕을 전부 확인해야 해서 O(N * M)
해시셋을 사용하면 앨리스의 사탕을 한 번만 저장(O(N))하고, 
탐색도 O(1) → O(N + M) 으로 훨씬 빠름

ㄴ 즉, 빠른 탐색(lookup) 속도 때문에 해시셋을 쓴다.
*/