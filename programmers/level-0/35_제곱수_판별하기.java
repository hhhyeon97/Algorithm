
// https://school.programmers.co.kr/learn/courses/30/lessons/120909

class Solution {
    public int solution(int n) {
        // n의 제곱근을 구함
        double sqrt = Math.sqrt(n);
        
        // 제곱근을 정수로 변환한 값 (int) sqrt와 비교
        // 제곱근이 정수이면 해당 숫자는 제곱수
        if (sqrt == (int) sqrt) {
            return 1; // 제곱수일 경우 1 반환
        } else {
            return 2; // 제곱수가 아닐 경우 2 반환
        }
    }
}