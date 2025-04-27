
// https://school.programmers.co.kr/learn/courses/30/lessons/181938

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        answer=(Integer.parseInt(a+""+b+"")>(2*a*b))?Integer.parseInt(a+""+b+""):(2*a*b);
        
        return answer;
    }
}