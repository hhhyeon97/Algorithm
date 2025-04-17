
// https://school.programmers.co.kr/learn/courses/30/lessons/181834
 
class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        for(char c : myString.toCharArray()){
            // a 아스키 코드 값 = 97
            // ㄴ l 아스키 코드 값 = 108
            if(c < 108){
                answer.append("l");
            }else {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}