
// https://school.programmers.co.kr/learn/courses/30/lessons/120895

// 문자열 위치 바꾸기
class Solution {
    public String solution(String my_string, int num1, int num2) {
        
        StringBuilder sb = new StringBuilder(my_string);

        char c = sb.charAt(num1);
        sb.setCharAt(num1, sb.charAt(num2));
        sb.setCharAt(num2, c);

        return sb.toString();
    }
}