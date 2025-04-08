
// https://school.programmers.co.kr/learn/courses/30/lessons/181919

import java.util.*;
class Solution {
    public int[] solution(int n) {
        
        List<Integer> list = new ArrayList<>();
        list.add(n);
        
        while(n != 1){
            if(n%2==0){
                n = n/2;
                list.add(n);
            }else{
                n = n*3+1;
                list.add(n);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}