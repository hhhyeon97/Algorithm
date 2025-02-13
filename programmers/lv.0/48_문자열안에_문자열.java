
// https://school.programmers.co.kr/learn/courses/30/lessons/120908

// 문자열 안에 문자열 존재 유무 구하는 문제

class Solution {
    public int solution(String str1, String str2) {

        int answer = 0;
        
        if(str1.contains(str2)){
            answer = 1; 
        }else {
            answer = 2;
        }
        return answer;
    }
}