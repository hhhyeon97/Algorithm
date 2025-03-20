
// https://school.programmers.co.kr/learn/courses/30/lessons/181844

import java.util.*;

class Solution {
    public List solution(int[] arr, int[] delete_list) {
        
        List<Integer> answer = new ArrayList<>();
      
        // arr 배열의 모든 요소를 리스트에 추가
        for (int num : arr) {
            answer.add(num);
        }
        // delete_list에 있는 요소를 리스트에서 제거
        for(int del : delete_list){
            int index = answer.indexOf(del);  // 삭제할 요소의 인덱스 찾기

            // 요소가 존재하면 제거
            if (index != -1) {
                answer.remove(index);
            }
        }
        // 삭제 후 남은 요소들이 저장된 리스트 반환
        return answer;
    }
}
