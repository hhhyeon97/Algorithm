
// https://school.programmers.co.kr/learn/courses/30/lessons/181865

class Solution {
    public int solution(String binomial) {
        int answer = 0;
        // 이항식을 공백으로 분리
        String[] parts = binomial.split(" ");
        
        // 첫번째 정수
        int a = Integer.parseInt(parts[0]);
        // 연산자
        String op = parts[1];
        // 두번째 정수
        int b = Integer.parseInt(parts[2]);
        
        // 연산자 비교 후 계산 수행
        if (op.equals("+")) {
            answer = a + b;
        } else if (op.equals("-")) {
            answer = a - b;
        } else if (op.equals("*")) {
            answer = a * b;
        }
        
        return answer;
    }
}