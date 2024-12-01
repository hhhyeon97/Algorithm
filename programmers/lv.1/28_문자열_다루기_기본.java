
// https://school.programmers.co.kr/learn/courses/30/lessons/12918


// Character.isDigit 메서드 : 문자열의 각 문자가 숫자인지 확인

class Solution {
    public boolean solution(String s) {
        // 문자열의 길이가 4 또는 6인지 확인
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        // 문자열이 숫자로만 구성되어 있는지 확인
        for (int i = 0; i < s.length(); i++) {
            // 숫자가 아닌 문자가 하나라도 있으면 false 반환
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        // 모든 조건을 만족하면 true 반환
        return true; 
    }
}