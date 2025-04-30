
// https://school.programmers.co.kr/learn/courses/30/lessons/120844

// 문제 볼 때 입출력 예시 보면서 규칙을 찾자!
class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        if(direction.equals("right")) {
            answer[0] = numbers[numbers.length - 1];
            for(int i = 1; i < answer.length; i++) {
                 answer[i] = numbers[i - 1];
            }
        }else {
            answer[numbers.length - 1] = numbers[0];
            for(int i = 0; i < answer.length -1; i++) {
                answer[i] = numbers[i + 1];
            }
        }
        
        return answer;
    }
}