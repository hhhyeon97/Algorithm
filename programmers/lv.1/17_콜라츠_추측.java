
// https://school.programmers.co.kr/learn/courses/30/lessons/12943

class Solution {
    public int solution(int num) {
        int count = 0;
        long n = num; // int 범위 초과를 방지하기 위해 long으로 변환

        while (n != 1) {
            if (count == 500) {
                return -1; // 500번을 초과한 경우
            }
            // 3항 연산자 사용 -> 짝수/홀수 조건 처리
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1; 
            count++;
        }

        return count; // 1이 될 때까지의 작업 횟수 반환
    }
}