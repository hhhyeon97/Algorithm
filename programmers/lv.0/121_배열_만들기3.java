
// https://school.programmers.co.kr/learn/courses/30/lessons/181895

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        
        // 리스트 생성
        List<Integer> list = new ArrayList<>();
        
        // 반복문 돌면서 리스트에 조건에 맞는 값 담기
        for(int i=0; i<intervals.length; i++){
            for(int j=intervals[i][0]; j<=intervals[i][1]; j++) {
                list.add(arr[j]);
            }
        }
        
        // 배열 생성
        int[] answer = new int[list.size()];
        
        // 배열에 리스트 값 담고 반환하기
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}