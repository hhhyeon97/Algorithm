
// https://school.programmers.co.kr/learn/courses/30/lessons/120897

// 약수를 저장할 배열의 길이를 먼저 구하기!

class Solution {
    public int[] solution(int n) {
        
        // 약수 개수 저장할 변수
        int count = 0;
        
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        
        // 약수 저장할 배열
        int[] answer = new int[count];
        
        int index = 0;
        
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                answer[index++] = i;
            }
        }

        return answer;
    }
}