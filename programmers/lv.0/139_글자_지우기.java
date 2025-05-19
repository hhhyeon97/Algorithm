
// https://school.programmers.co.kr/learn/courses/30/lessons/181900

import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        // 인덱스 정렬
        Arrays.sort(indices);
        
        // 빌더 객체 생성
        StringBuilder sb = new StringBuilder(my_string);
        
        // 반복문 돌리면서 해당 인덱스 글자 제거
        for(int i = indices.length - 1; i >= 0; i--) {
            sb.deleteCharAt(indices[i]);
        }
        
        // 객체를 문자열로 변경 후 반환
        String answer = sb.toString();
        
        return answer;
    }
}