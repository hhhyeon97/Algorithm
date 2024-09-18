
// https://school.programmers.co.kr/learn/courses/30/lessons/120825

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder result = new StringBuilder();
        
        // 문자열의 각 문자를 n번 반복해서 StringBuilder에 추가
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            for (int j = 0; j < n; j++) {
                result.append(ch);
            }
        }
        
        return result.toString();  // 최종 문자열 반환
    }
}