
// https://school.programmers.co.kr/learn/courses/30/lessons/120889

import java.util.*;

class Solution {
    public int solution(int[] sides) {

        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(sides);
        
        // 가장 긴 변 제외한 두 변 길이 합
        int a = sides[0]+sides[1];
        
        // 문제 조건
        // 가장 긴 변의 길이는 다른 두 변의
        // 길이의 합보다 작아야 한다.
        if(sides[2]<a){
            answer = 1;
        }else {
            answer = 2;
        }

        return answer;
    }
}