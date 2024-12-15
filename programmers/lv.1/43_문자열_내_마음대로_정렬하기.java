
// https://school.programmers.co.kr/learn/courses/30/lessons/12915

/*
정렬해야 하는 문제 기준 이해하기
ㄴ 각 문자열의 n번째 문자를 첫 번째 기준
ㄴ n번째 문자가 동일한 경우, 문자열 자체를 사전순 정렬

Java에서는 Arrays.sort() 메서드에 
Comparator를 전달해 커스터마이징된 정렬 기준을 적용할 수 있음
*/

// ※ Character.compare()는 문자 단위 비교, compareTo()는 문자열 전체 비교에 사용한다.

import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {

        // ex ) strings = ["sun", "bed", "car"]

        // 정렬 기준 설정
        // s1과 s2는 비교할 두 문자열을 나타내는 변수임
        // ㄴ (ex → "sun", "bed", "car" 중 두 개를 비교하기 위해 사용됨)
        Arrays.sort(strings, (s1, s2) -> {
            
            // 1. 두 문자열의 n번째 문자 비교
            if (s1.charAt(n) != s2.charAt(n)) {
                return Character.compare(s1.charAt(n), s2.charAt(n));
                /*
                Character.compare(s1.charAt(n), s2.charAt(n))
                ㄴ 두 문자를 비교해서 정렬 순서를 결정하는 코드
                Character.compare() :
                두 문자의 ASCII 값을 비교한다 :
                음수: s1.charAt(n)이 s2.charAt(n)보다 앞에 온다.
                0: 두 문자가 같다.
                양수: s1.charAt(n)이 s2.charAt(n)보다 뒤에 온다.
                예를 들어:
                "u"와 "e"를 비교 → 
                "u"의 ASCII 값(117)이 "e"의 ASCII 값(101)보다 크다 →
                양수 반환 → 
                "e"가 앞에 배치됨.
                */
            }
            // 2. n번째 문자가 같으면 문자열 자체를 사전순으로 비교
            return s1.compareTo(s2);
        });

        return strings;
    }
}
