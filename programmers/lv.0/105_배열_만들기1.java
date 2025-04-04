
// https://school.programmers.co.kr/learn/courses/30/lessons/181901

import java.util.*; 

class Solution {
    public int[] solution(int n, int k) {
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            if(i%k==0){
                answer.add(i);
            }
        }
        
        int[] arr = new int[answer.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = answer.get(i);
        }
            
        return arr;
    }
}