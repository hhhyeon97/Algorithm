
// https://school.programmers.co.kr/learn/courses/30/lessons/181929

class Solution {
    public int solution(int[] num_list) {
        
        int answer = 0;
        int sum = 0;
        int square = 1;
        
        for(int n : num_list){
            square *= n;
            sum += n;
            if(sum*sum > square){
                answer = 1;
            }else{
                answer = 0;
            }
        }
        return answer;
    }
}