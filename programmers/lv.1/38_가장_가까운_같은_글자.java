
// https://school.programmers.co.kr/learn/courses/30/lessons/142086

import java.util.HashMap;

class Solution {
    public int[] solution(String s) {

        // 시간 복잡도
        // 문자열 길이 n에 대해 한 번씩 탐색함 -> O(n)
        // 각 문자의 기록 업데이트 및 조회는 HashMap을 사용해 평균적으로 O(1)

        int[] answer = new int[s.length()];
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // 이전 위치를 확인
            if (lastSeen.containsKey(currentChar)) {
                answer[i] = i - lastSeen.get(currentChar); // 현재 위치와 마지막 위치의 거리 계산
            } else {
                answer[i] = -1; // 이전에 등장한 적이 없는 경우
            }
            
            // 현재 문자의 위치를 업데이트
            lastSeen.put(currentChar, i);
        }
        /*
        ex )
        문자열 s = "banana"
        b: 처음 등장 → -1
        a: 처음 등장 → -1
        n: 처음 등장 → -1
        a: 2칸 떨어짐 → 2
        n: 2칸 떨어짐 → 2
        a: 2칸 떨어짐 → 2
        결과: [-1, -1, -1, 2, 2, 2]
        */
        
        return answer;
    }
}