
// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length]; // 결과를 저장할 배열
        
        /* ex ) 
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
         */
        // commands 배열 순회
        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0]; // 시작 인덱스
            int j = commands[idx][1]; // 끝 인덱스
            int k = commands[idx][2]; // k번째 숫자
            
            // array의 i번째부터 j번째까지 자르기
            int[] sliced = Arrays.copyOfRange(array, i - 1, j); // 인덱스는 0부터 시작
            
            // 잘라낸 배열 정렬
            Arrays.sort(sliced);
            
            // 정렬된 배열의 k번째 숫자 추출
            result[idx] = sliced[k - 1]; // k번째 숫자는 배열에서 k-1 인덱스
        }
        /* for문 부분 설명
        첫 번째 반복 (명령: {2, 5, 3})
        idx = 0, 명령은 {2, 5, 3}.

        i = 2, j = 5, k = 3.

        배열 array에서 2번째부터 5번째까지 자른다.
        → Arrays.copyOfRange(array, 1, 5) → [5, 2, 6, 3].
        (1을 빼는 이유: Java 배열 인덱스는 0부터 시작하니까!)

        자른 배열을 정렬한다.
        → 정렬 후: [2, 3, 5, 6].

        정렬된 배열에서 k번째 숫자를 가져온다.
        → sliced[3 - 1] → sliced[2] → 값은 5.

        결과 배열에 저장.
        → result[0] = 5.
        
        ㄴ> 이런 과정으로 반복됨
        */
        
        // 결과 : [5, 6, 3]
        return result;
    }
}