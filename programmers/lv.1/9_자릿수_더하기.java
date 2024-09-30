
// https://school.programmers.co.kr/learn/courses/30/lessons/12931


class Solution {
    public int solution(int n) {
        // 1. 숫자 N을 문자열로 바꾸기
        String str = Long.toString(n);
        
        // 2. 문자열의 각 문자를 배열로 만들기 
        char[] charArray = str.toCharArray();
        
        // 3. 각 자릿수 합 구하기
        int sum = 0;
         for (int i = 0; i < charArray.length; i++) {
             sum += charArray[i] - '0';
         }
        return sum;
        
    }
}