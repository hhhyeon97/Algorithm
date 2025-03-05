
// https://school.programmers.co.kr/learn/courses/30/lessons/181853

import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        
        int[] answer = new int[5];
        
        // 오름차순 정렬
        Arrays.sort(num_list);
        
        for(int i=0; i<=4; i++){
            answer[i] = num_list[i];
        }
        
        return answer;
    }
}
