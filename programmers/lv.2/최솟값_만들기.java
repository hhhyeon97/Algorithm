
// https://school.programmers.co.kr/learn/courses/30/lessons/12941

import java.util.*;

class Solution {
    public int solution(int []A, int []B) {

       // 1. 배열 A를 오름차순 정렬
       Arrays.sort(A);
       // 2. 배열 B를 오름차순 정렬 (내림차순으로 접근하기 위해 뒤에서부터 값 사용할 예정)
       Arrays.sort(B);
       
       // 3. 누적값 계산 (A의 작은 값과 B의 큰 값을 곱함)
       int answer = 0;
       
       for (int i = 0; i < A.length; i++) {
           answer += A[i] * B[B.length - 1 - i]; // b에서 큰 값 -> 위에서 B를 오름차순 정렬했으므로 뒤 인덱스가 가장 큰 값을 가지고 있는 상태
       }
       return answer;
    }
}