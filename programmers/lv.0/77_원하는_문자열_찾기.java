
// https://school.programmers.co.kr/learn/courses/30/lessons/181878

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        if(pat.length() > myString.length()){
            answer = 0;
        }
        
        if(myString.toLowerCase().contains(pat.toLowerCase())){
            answer = 1;
        }
        
        return answer;
        
    }
}