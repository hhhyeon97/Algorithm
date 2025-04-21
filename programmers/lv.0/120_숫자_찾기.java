
// https://school.programmers.co.kr/learn/courses/30/lessons/120904

class Solution {
    public int solution(int num, int k) {
        
        // 초기값 설정
        int answer = -1; 

        String str = Integer.toString(num);
        
        // 문자열로 바꾼 숫자 문자열 배열로 쪼개기
        String[] arr = str.split("");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(Integer.toString(k))) {
                // k가 있는 num의 자리 수만 구하면
                //answer값 업데이트하고 루프 빠져나가도 됨
                answer = i + 1; 
                break;
            }
        }
        return answer;
    }
}
