
// https://school.programmers.co.kr/learn/courses/30/lessons/181937

class Solution {
    public int solution(int num, int n) {
        int answer = 0;
      
        if(num%n==0){
            answer = 1;
        }else {
            answer = 0;
        }
      
        return answer;
    }
}
