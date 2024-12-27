
// https://school.programmers.co.kr/learn/courses/30/lessons/138477

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        // 최소 힙 사용
        PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();

        // 결과 담을 동적인 리스트
        List<Integer> result = new ArrayList<>();

        /* 과정
        매일 새 점수를 명예의 전당에 추가
        k를 초과하면 최솟값을 제거
        현재 목록의 최솟값을 결과 리스트에 추가
        */
        
        for (int s : score) {
            hallOfFame.add(s); // 점수를 추가
            
            if (hallOfFame.size() > k) {
                hallOfFame.poll(); // 크기 초과 시 최솟값 제거
            }
            
            result.add(hallOfFame.peek()); // 최하위 점수를 결과에 추가
        }
        // 리스트를 배열로 변환하여 반환 (for문 써도 되는데 stream 사용하면 좀 더 간단히 변환 가능)
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}