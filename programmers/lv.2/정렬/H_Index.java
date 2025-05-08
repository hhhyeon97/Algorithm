
// https://school.programmers.co.kr/learn/courses/30/lessons/42747

import java.util.*;
class Solution {
    public int solution(int[] citations) {
        // 구할 값 : H-Index
        // ㄴ 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
        // 나머지 논문이 h번 이하 인용되었을 때 h의 최댓값
        
        // ex) citations = [3, 0, 6, 1, 5]
        int answer = 0;
        
        // 논문의 인용 횟수 담긴 배열 오름차순 정렬
        Arrays.sort(citations);
        // [0, 1, 3, 5, 6]
        
        // 인용 횟수와 남은 논문 수를 비교하여 H-Index 계산
        for(int i=0; i<citations.length; i++){
            int s = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, s);
        }
        // 3 
        return answer;
    }
}