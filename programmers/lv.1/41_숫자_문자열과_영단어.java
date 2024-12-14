
// https://school.programmers.co.kr/learn/courses/30/lessons/81301

import java.util.*;
class Solution {
    public int solution(String s) {
       // 숫자에 대응되는 영단어를 HashMap에 저장
        HashMap<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        // 영단어를 숫자로 변환
        for (String key : map.keySet()) {
           // 각 key(영단어)가 문자열 s에 있는지 확인
           // 있으면 숫자로 치환하고, 없으면 그대로 둠
           // 반복이 끝나면 모든 영단어가 숫자로 바뀌어 최종 문자열이 만들어짐
            s = s.replace(key, map.get(key));
        }
        
        // 숫자 문자열을 정수로 변환하여 반환
        return Integer.parseInt(s);
    }
}