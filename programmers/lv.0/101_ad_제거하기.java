
// https://school.programmers.co.kr/learn/courses/30/lessons/181870

import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        
        List<String> answer = new ArrayList<>();
        
        for(String s : strArr){
            if(!s.contains("ad")){
                answer.add(s);
            }
        }
        String[] result = answer.toArray(String[]::new);
        return result;
    }
}
