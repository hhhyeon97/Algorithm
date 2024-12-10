
// https://school.programmers.co.kr/learn/courses/30/lessons/12926

class Solution {
    public String solution(String s, int n) {
       StringBuilder result = new StringBuilder(); // 결과 문자열 저장

        for (char c : s.toCharArray()) { // 문자열을 문자 배열로 변환 후 순회

            // 대문자와 소문자를 구분하여 각각 처리

            if (Character.isUpperCase(c)) { // 대문자 처리
                result.append((char) ((c - 'A' + n) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) { // 소문자 처리
                result.append((char) ((c - 'a' + n) % 26 + 'a'));
            } else { // 공백 처리
                result.append(c);
            }
        }

        return result.toString(); // 결과 반환
    }
}
/*

ex )

입력값: "AB", n = 1
문자열의 각 문자를 순회하며 처리

- 첫 번째 문자: 'A'

1. 현재 문자: 'A'
'A'는 대문자.

2. 알파벳 밀기 계산:
'A'의 ASCII 값: 65
'A'를 기준으로 0부터 시작: c - 'A' = 65 - 65 = 0
n을 더함: 0 + 1 = 1
26으로 나눈 나머지: 1 % 26 = 1
다시 'A' 기준으로 위치를 계산: 1 + 'A' = 1 + 65 = 66
결과 문자: 'B'

3. 결과 문자열에 'B' 추가.

- 두 번째 문자: 'B'

1. 현재 문자: 'B'
'B'는 대문자.

2. 알파벳 밀기 계산:
'B'의 ASCII 값: 66
'B'를 기준으로 0부터 시작: c - 'A' = 66 - 65 = 1
n을 더함: 1 + 1 = 2
26으로 나눈 나머지: 2 % 26 = 2
다시 'A' 기준으로 위치를 계산: 2 + 'A' = 2 + 65 = 67
결과 문자: 'C'

3. 결과 문자열에 'C' 추가.

최종 결과
ㄴ> 두 문자 모두 처리 후 결과 문자열은 "BC"가 됨

*/