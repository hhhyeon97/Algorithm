
// https://leetcode.com/problems/find-the-difference/description/

// 풀이 1. 정렬 활용

import java.util.*;

class Solution1 {
    public char findTheDifference(String s, String t) {
        // 문자열 → 문자 배열로 변환
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // 배열 정렬
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // 비교하면서 다른 문자 찾기
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return tArr[i];
            }
        }

        // 마지막 문자가 추가된 경우
        return tArr[tArr.length - 1];
    }
}

// 풀이 2. 문자 아스키 값 합 비교
// 풀이2 제출 결과가 이 문제에서 시간/메모리적으로 더 효과적

class Solution2 {
    public char findTheDifference(String s, String t) {

        int sumS = 0, sumT = 0;

        // 문자열 s와 t의 문자들을 순회하면서 아스키 값 더하기
        for (char c : s.toCharArray()) {
            sumS += c;
        }
        for (char c : t.toCharArray()) {
            sumT += c;
        }

        // t의 합에서 s의 합을 뺀 결과가 추가된 문자에 해당함 !
        return (char) (sumT - sumS);
    }
}

//