
// https://school.programmers.co.kr/learn/courses/30/lessons/76501

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for(int i=0; i<absolutes.length; i++){
            if(signs[i]==false){
                absolutes[i] = -absolutes[i];
            }
        }
        for(int i=0; i<absolutes.length; i++){
            sum += absolutes[i];
        }        
        return sum;
    }
}