
// https://school.programmers.co.kr/learn/courses/30/lessons/181925

class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();

        // 인덱스를 1부터 설정
        // 첫번째 원소와 그 전 원소를 비교해서 도출하려고
        for(int i=1; i<numLog.length; i++){
              if(numLog[i]-numLog[i-1] == 1){
                answer.append("w");
            }else if(numLog[i]-numLog[i-1] == -1){
                answer.append("s");
            }else if(numLog[i]-numLog[i-1] == 10){
                answer.append("d");
            }else if(numLog[i]-numLog[i-1] == -10){
                answer.append("a");
            }
        }
        return answer.toString();
    }
}