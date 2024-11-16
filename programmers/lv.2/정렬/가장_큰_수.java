
// https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
         // 정렬 기준 정의
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        // 정렬된 문자열을 합침
        StringBuilder result = new StringBuilder();
        for (String num : strNumbers) {
            result.append(num);
        }
        
        // 결과가 0으로만 이루어졌을 경우 처리
        if (result.charAt(0) == '0') {
            return "0";
        }
        // 결과 객첼
        return result.toString();
    }
}

/*
자바의 Arrays.sort는 배열을 정렬하는 메서드로, 두 가지 버전을 제공한다.

1. 기본 정렬: 숫자나 문자열 등 기본 데이터 타입은 자동으로 오름차순 정렬함
2. 사용자 정의 정렬: Comparator를 통해 정렬 기준을 지정할 수 있음

=================
람다식
(a, b) -> (b + a).compareTo(a + b)는 람다식으로, 자바에서 간결하게 코드를 작성하는 방법이다.

람다식 구조
(매개변수) -> { 실행할 코드 }
a와 b는 두 개의 비교 대상(문자열).
->는 "이 두 매개변수로 다음 동작을 수행하라"는 의미.
{ 실행 코드 }는 비교 방법을 구현.

ex )

(b + a).compareTo(a + b):
두 문자열 a와 b를 이어 붙인다.
b + a와 a + b를 비교.
compareTo는 두 문자열을 사전순으로 비교.
반환값이 0이면 두 문자열이 동일.
양수이면 b + a가 더 크다 → b가 먼저 온다.
음수이면 a + b가 더 크다 → a가 먼저 온다.

왜 (b + a)와 (a + b)를 비교?
가장 큰 숫자를 만들려면 문자열을 이어 붙였을 때 더 큰 값이 앞에 오도록 해야 한다.

예: 3과 30이 있을 때,
b + a = "303"
a + b = "330"
"330"이 더 크므로 3이 앞에 온다.
*/