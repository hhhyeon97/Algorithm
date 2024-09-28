// https://school.programmers.co.kr/learn/courses/30/lessons/12928

class Solution {
    public int solution(int n) {
        int answer = 0; // 약수의 합을 저장할 변수 초기화

        // 1부터 n의 절반까지 반복
        for (int i = 1; i <= n / 2; i++) {
            // n이 i로 나누어 떨어지면 i는 n의 약수
            if (n % i == 0) answer += i; // i를 약수로 더함
        }

        // n 자신도 약수이므로, 마지막에 n을 더해줌
        return answer + n;
    }
}