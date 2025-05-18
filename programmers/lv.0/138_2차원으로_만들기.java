
// https://school.programmers.co.kr/learn/courses/30/lessons/120842

class Solution {
    public int[][] solution(int[] num_list, int n) {
        // ex) num_list = [1, 2, 3, 4, 5, 6, 7, 8] -> 길이 : 8
        // n = 2 
        // 2차원 배열 -> 4 * 2
        // num_list의 원소들을 앞에서부터 n개씩 나눠야 함
        // [[1, 2], [3, 4], [5, 6], [7, 8]]
        int[][] answer = new int[num_list.length/n][n];
        
        int count = 0;
        
        for(int i=0; i<num_list.length/n; i++){
            for(int j=0; j<n; j++){
                answer[i][j] = num_list[count++];
            }
        }
        
        return answer;
    }
}