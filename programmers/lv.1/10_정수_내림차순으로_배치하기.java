
// https://school.programmers.co.kr/learn/courses/30/lessons/12933

import java.util.*;

class Solution {
    public long solution(long n) {

         // 1. 정수를 문자열로 변환
        String str = Long.toString(n);
        
        // 2. 문자열을 문자 배열로 변환
        Character[] charArray = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        // 3. 문자 배열 정렬 (내림차순)
        Arrays.sort(charArray, Collections.reverseOrder());

        // 4. 정렬된 문자 배열을 다시 문자열로 변환
        StringBuilder sortedStr = new StringBuilder();
        for (char c : charArray) {
            sortedStr.append(c);
        }

        // 5. 문자열을 정수로 변환하여 반환
        return Long.parseLong(sortedStr.toString());
    }
}