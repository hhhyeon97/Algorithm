
// https://school.programmers.co.kr/learn/courses/30/lessons/120826

class Solution {
    public String solution(String my_string, String letter) {
          
        StringBuilder resultStr = new StringBuilder();
        
        // my_string의 각 문자를 순회
        for (char c : my_string.toCharArray()) {
            // letter와 같지 않은 경우에만 resultStr에 추가
            if (c != letter.charAt(0)) {
                resultStr.append(c);
            }
        }
        
        return resultStr.toString();
    }
}