
// https://school.programmers.co.kr/learn/courses/30/lessons/181930

class Solution {
    public int solution(int a, int b, int c) {
        int answer = a+b+c;
        
        if(a==b && b==c){
            answer = answer * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        }else if(a!=b && b!=c && a!=c){
            return answer;
        }else{
           answer = answer * (a*a + b*b + c*c);
        }
        return answer;
    }
}