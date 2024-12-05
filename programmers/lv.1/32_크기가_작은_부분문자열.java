
// https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java

class Solution {
    public int solution(String t, String p) {
        int count = 0;
        int pLength = p.length(); // p의 길이
        long pValue = Long.parseLong(p); // p를 숫자로 변환
        
        // t에서 p와 길이가 같은 부분 문자열 탐색
        for (int i = 0; i <= t.length() - pLength; i++) {
            // 부분 문자열 추출
            String sub = t.substring(i, i + pLength);
            long subValue = Long.parseLong(sub); // 부분 문자열을 숫자로 변환
            
            // 조건 비교
            if (subValue <= pValue) {
                count++;
            }
        }
        
        return count; // 결과 반환
    }
}