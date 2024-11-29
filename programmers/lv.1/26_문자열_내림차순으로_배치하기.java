
// https://school.programmers.co.kr/learn/courses/30/lessons/12917

import java.util.*;

class Solution {
    public String solution(String s) {
        // 문자열을 문자 배열로 변환
        Character[] charArray = new Character[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }
        
        // 문자 배열을 내림차순으로 정렬
        Arrays.sort(charArray, Collections.reverseOrder());
        
        // 정렬된 배열을 문자열로 변환
        StringBuilder sortedString = new StringBuilder();

        for (char c : charArray) {
            sortedString.append(c);
        }
        
        return sortedString.toString();
    }
}

/*
문자 배열로 변환
ㄴ s.charAt(i)를 이용해 Character 배열로 변환한다.
ㄴ Character 배열로 만든 이유는 Collections.reverseOrder()를 사용하기 위해서다.

내림차순 정렬
ㄴ Arrays.sort()와 Collections.reverseOrder()를 사용해 정렬 기준을 설정한다.
ㄴ Java에서 기본 정렬은 오름차순이므로 -> reverseOrder()로 내림차순 설정.

문자열로 변환
ㄴ 정렬된 배열의 문자를 StringBuilder에 추가해 최종 문자열을 생성한다.
==========================================================================
대문자는 소문자보다 ASCII 값이 작아 정렬 시 자동으로 요구 조건에 맞게 처리된다.
Collections.reverseOrder()는 Comparable 인터페이스를 구현한 객체에만 사용할 수 있다. 
char 배열이 아닌 Character 배열로 변환한 이유다.
*/