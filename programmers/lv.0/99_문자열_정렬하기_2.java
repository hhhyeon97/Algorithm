
// https://school.programmers.co.kr/learn/courses/30/lessons/120911

import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        String answer = "";
        
        String[] abcArray = my_string.toLowerCase().split("");

        Arrays.sort(abcArray);

        for (int i = 0; i < abcArray.length; i++) {
            answer += abcArray[i];
        }

        return answer;
    }
}
