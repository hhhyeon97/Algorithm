
// https://school.programmers.co.kr/learn/courses/30/lessons/176963

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // 1. 이름과 그리움 점수를 매핑한 해시맵 생성
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }

        // 2. 각 사진별로 추억 점수 계산
        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String person : photo[i]) {
                sum += scoreMap.getOrDefault(person, 0); // 이름이 없으면 0점
            }
            result[i] = sum;
        }

        return result;
    }
}