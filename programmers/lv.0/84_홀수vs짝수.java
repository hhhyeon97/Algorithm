
// https://school.programmers.co.kr/learn/courses/30/lessons/181887

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<num_list.length; i++){
            if(i==0){
                sum1 += num_list[i];
            }else if(i%2!=0){
                sum2 += num_list[i];
            }else {
                sum1 += num_list[i];
            }
        }
        answer = Math.max(sum1,sum2);
        return answer;
    }
}
