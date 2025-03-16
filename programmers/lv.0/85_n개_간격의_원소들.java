
// https://school.programmers.co.kr/learn/courses/30/lessons/181888

import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<num_list.length; i+=n){
            list.add(num_list[i]);
        }
        // 스트림 사용하면 배열 생성 없이
        // 리스트를 int 배열로 변환 가능
        return list.stream().mapToInt(i -> i).toArray();
    }
}
