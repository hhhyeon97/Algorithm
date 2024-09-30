
// https://school.programmers.co.kr/learn/courses/30/lessons/12932

class Solution {
    public int[] solution(long n) {
       // 1. 숫자를 문자열로 변환하고, 이를 다시 char 배열로 변환
        String str = Long.toString(n);
        char[] charArray = str.toCharArray();
        
        
        // 2. 뒤집힌 숫자를 저장할 배열 생성
        int[] result = new int[charArray.length];
        
        // 3. 각 자리를 뒤에서부터 배열에 저장
        for (int i = 0; i < charArray.length; i++) {
            // 문자 '0' ~ '9'를 숫자로 변환하여 배열에 저장
            result[i] = charArray[charArray.length - 1 - i] - '0';
        }
        
        return result;
    }
}