package others;

import java.util.Scanner;

// 문자열에서 연속된 세 자리를 탐색해서
// 동일한 숫자로 이루어진 부분 문자열을 찾아야 함

class Solution {
    public int solution(String s) {
        int maxStylishNumber = -1;  // 가장 큰 멋쟁이 숫자를 저장할 변수, 초기값은 -1

        for (int i = 0; i < s.length() - 2; i++) {
            // 현재 위치에서 3자리 숫자를 확인
            String current = s.substring(i, i + 3);

            // 3자리 숫자가 모두 같은 경우
            if (current.charAt(0) == current.charAt(1) && current.charAt(1) == current.charAt(2)) {
                int number = Integer.parseInt(current);

                // 가장 큰 멋쟁이 숫자 갱신
                if (number > maxStylishNumber) {
                    maxStylishNumber = number;
                }
            }
        }

        // 만약 가장 큰 멋쟁이 숫자가 000이라면 0을 반환
        if (maxStylishNumber == 0) {
            return 0;
        }

        return maxStylishNumber;
    }
}