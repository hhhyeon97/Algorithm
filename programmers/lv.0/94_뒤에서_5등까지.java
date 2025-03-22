
// https://school.programmers.co.kr/learn/courses/30/lessons/181853

import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
       
        // 정수 리스트 선언
        List<Integer> answer = new ArrayList<>();
        
        // 오름차순 정렬
        Arrays.sort(num_list);
        
        // 가장 작은 수 5개 제외
        // ㄴ 정렬했으니 가장 앞에서부터 다섯번째까지를 제외하고 반복문 돌리기
        for (int i = 5; i < num_list.length; i++) {
            answer.add(num_list[i]);
        }
        // 리스트 -> 배열 변환 후 반환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
