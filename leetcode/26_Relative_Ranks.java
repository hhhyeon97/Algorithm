
// https://leetcode.com/problems/relative-ranks/description/

import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {

        // score 배열 길이
        int n = score.length;
        // 결과 담을 배열
        String[] result = new String[n];
        
        // (점수, 원래 인덱스) 저장
        int[][] scoresWithIndex = new int[n][2]; // 3등까지 메달 줄거니까 인덱스 길이는 (0,1,2) 2를 준다

        for (int i = 0; i < n; i++) {
            scoresWithIndex[i][0] = score[i]; // 점수
            scoresWithIndex[i][1] = i;        // 원래 인덱스
        }
        
        // 점수를 기준으로 내림차순 정렬
        Arrays.sort(scoresWithIndex, (a, b) -> Integer.compare(b[0], a[0]));
        
        // 순위 매기기
        for (int i = 0; i < n; i++) {
            int index = scoresWithIndex[i][1]; // 원래 인덱스
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);
            }
        }
        
        return result;
    }
}