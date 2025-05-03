
// https://school.programmers.co.kr/learn/courses/30/lessons/181866

// 처음에 단순하게 x 기준으로 잘라서 배열 만들고 정렬해서 리턴하니까
// 테스트만 통과하고 제출하면 틀렸음
// xxaxxb 이럴 경우엔 x 기준으로 자르면 빈 문자열 들어가는 경우가 생김
// 해결 : 조건문 넣어서 비어 있지 않을 경우에만 리스트에 넣어서 배열로 바꾸고 정렬해서 반환!!

import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String s:answer) {
            if(!s.isEmpty()){
                list.add(s);
            }
         }
        
        String[] result =  new String[list.size()];
        
        list.toArray(result);
        
        Arrays.sort(result);
        
        return result;
    }
}