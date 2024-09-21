

// https://school.programmers.co.kr/learn/courses/30/lessons/12954

class Solution {
    public long[] solution(int x, int n) {
         // 결과 배열을 n 크기로 선언
        long[] answer = new long[n];
        
        // i는 0부터 시작하고, x * (i + 1)을 배열에 채움
        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }
        /*
         * ex) x=2, n=5
         * 
         * int i=0 -> answer[0] = 2*1 = 2, answer[1] = 2*2 = 4, ....
         * 
         * ㄴ> [2,4,6,8,10] 
         * 
         */
        
        return answer;
    }
}