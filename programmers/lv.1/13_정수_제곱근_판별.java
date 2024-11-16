
// https://school.programmers.co.kr/learn/courses/30/lessons/12934

/*
n의 범위가 크기 때문에 long 타입을 사용해야 한다.
Math.pow 결과도 실수(double)이므로 long으로 변환해야 한다.
*/
class Solution {
    public long solution(long n) {
        // n의 제곱근 구하기
        double sqrt = Math.sqrt(n);
        
        // 제곱근이 정수인지 확인
        // ㄴ (실수 값에서 정수 부분만 남긴 후 비교한다. 같다면 정수이다.)
        if (sqrt == (int) sqrt) {
            // 제곱근이 정수라면 (sqrt + 1)^2 반환
            long result = (long) Math.pow((int) sqrt + 1, 2);
            return result;
        } else {
            // 정수가 아니라면 -1 반환
            return -1;
        }
    }
}