// https://school.programmers.co.kr/learn/courses/30/lessons/12916

class Solution {
    boolean solution(String s) {
      // 대소문자를 구별하지 않기 위해 소문자로 변환
        s = s.toLowerCase();
        
        // 'p'와 'y'의 개수 세기
        int pCount = 0;
        int yCount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'p') pCount++;
            if (c == 'y') yCount++;
        }
        
        // 'p'와 'y'의 개수가 같으면 true, 다르면 false
        return pCount == yCount;
    }
}