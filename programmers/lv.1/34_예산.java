
// https://school.programmers.co.kr/learn/courses/30/lessons/12982

/*
최대한 많은 부서에 물품을 지원해주기 위해
부서별 신청 금액 배열을 오름차순 정렬 후
예산보다 배열 원소가 작은 경우에만
예산에서 배열 원소 값을 빼주고 카운트해준다. 
*/

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++){
             if(budget < d[i]) {
                break;
            }
            budget -= d[i];
            answer++;
        }

        return answer;
    }
}