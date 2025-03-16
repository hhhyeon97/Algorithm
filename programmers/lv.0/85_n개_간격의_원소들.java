
// https://school.programmers.co.kr/learn/courses/30/lessons/181888

import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<num_list.length; i+=n){
            list.add(num_list[i]);
        }
        
        int[] result = new int[list.size()];
        
        // 리스트를 int 배열로 변환
        return list.stream().mapToInt(i -> i).toArray();
    }
}
