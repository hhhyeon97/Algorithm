
// https://school.programmers.co.kr/learn/courses/30/lessons/181899

import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {

        List<Integer> answer = new ArrayList<>();
        
        // 리스트에 거꾸로 값 담기
        for(int i=start_num; i>=end_num; i--){
            answer.add(i);
        }
        
        // 리스트 -> 배열 변환
        int[] arr = new int[answer.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = answer.get(i);
        }
        return arr;
    }
}