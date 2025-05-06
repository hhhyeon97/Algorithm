
// https://school.programmers.co.kr/learn/courses/30/lessons/181829

//  i + j <= k 라면 board[i][j]의 값 더하기

class Solution {
    public int solution(int[][] board, int k) {
        
        int answer = 0;
        
        for(int i =0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++) {
                if(i+j <= k) {
                    answer += board[i][j];
                }
            }
        }
        
        return answer;
    }
}