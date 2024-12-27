
// https://school.programmers.co.kr/learn/courses/30/lessons/138477

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        
        for (int s : score) {
            hallOfFame.add(s); // 점수를 추가
            
            if (hallOfFame.size() > k) {
                hallOfFame.poll(); // 크기 초과 시 최솟값 제거
            }
            
            result.add(hallOfFame.peek()); // 최하위 점수를 결과에 추가
        }
        
        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}