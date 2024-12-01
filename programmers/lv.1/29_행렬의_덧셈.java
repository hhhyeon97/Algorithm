
// https://school.programmers.co.kr/learn/courses/30/lessons/12950

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬의 크기와 동일한 크기로 결과 배열 초기화
        // ㄴ> 크기가 없으면 오류 발생
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        // 행렬의 각 원소를 순회하며 덧셈 수행
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}