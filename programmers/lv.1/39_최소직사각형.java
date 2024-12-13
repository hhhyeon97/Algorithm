
// https://school.programmers.co.kr/learn/courses/30/lessons/86491

class Solution {
    public int solution(int[][] sizes) {

        int maxWidth = 0;
        int maxHeight = 0;
        
        // 모든 명함을 돌면서 가로와 세로를 정리
        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);  // 가로와 세로 중 더 큰 값을 가로로 설정
            int height = Math.min(size[0], size[1]); // 가로와 세로 중 더 작은 값을 세로로 설정
            
            // 최대 가로와 최대 세로 갱신
            if (width > maxWidth) {
                maxWidth = width;
            }
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        /* ex )
        Math.max(5, 8) → 8 (큰 값을 width로 설정)
        Math.min(5, 8) → 5 (작은 값을 height로 설정)
        ㄴ 이렇게 하면 명함이 어떻게 주어지든 
        명함 모두를 수납할 수 있는 가장 작은 지갑 크기 구할 수 있다.
        */

        // 지갑의 최소 크기 계산
        return maxWidth * maxHeight;
    }
}