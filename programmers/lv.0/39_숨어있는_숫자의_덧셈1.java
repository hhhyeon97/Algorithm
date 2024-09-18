
// https://school.programmers.co.kr/learn/courses/30/lessons/120851

class Solution {
    public int solution(String my_string) {
        int sum = 0;
        // 문자열을 한 글자씩 순회하며 숫자인지 확인
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (Character.isDigit(ch)) {
                // 숫자인 경우 정수로 변환하여 더해줌
                sum += ch - '0';  // '0'을 빼면 해당 문자의 숫자 값이 됨
            }
        }
        return sum;
    }
}