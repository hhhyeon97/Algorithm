
// https://school.programmers.co.kr/learn/courses/30/lessons/181905

// reverse 메서드 활용하기!

class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = s;i <= e; i++){
            answer.append(my_string.charAt(i));
        }
        
        return my_string.substring(0, s) + answer.reverse().toString() 
            + my_string.substring(e + 1, my_string.length());
    }
}