
// https://school.programmers.co.kr/learn/courses/30/lessons/120910

class Solution {
    public int solution(int n, int t) {
         // t시간 후 세균 수는 n * 2^t로 계산
        return n * (int)Math.pow(2, t);
    }
}