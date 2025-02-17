
// https://school.programmers.co.kr/learn/courses/30/lessons/181939

class Solution {
    public int solution(int a, int b) {
        
        // 숫자 -> 문자열로 변환 후 이어 붙이기
        String s1 = String.valueOf(a) + String.valueOf(b);
        String s2 = String.valueOf(b) + String.valueOf(a);
        
        // 정수형으로 변환
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        
        // 더 큰 값 반환
        return Math.max(n1, n2);
    }
}