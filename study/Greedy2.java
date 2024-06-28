/*
https://leetcode.com/problems/maximum-odd-binary-number/

주어진 이진 문자열을 재배열하여 
가장 큰 홀수 이진 숫자를 만드는 문제

마지막 자리에 '1'을 배치하고, 나머지 비트를 내림차순으로 정렬하는 것
이렇게 하면 가장 큰 값을 만들 수 있다.
*/

class Solution {
    public String maximumOddBinaryNumber(String s) {
         int count1 = 0;
        int count0 = 0;
        
        // 문자열을 순회하며 '1'과 '0'의 개수 세기
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
            } else {
                count0++;
            }
        }

        // 결과 문자열의 마지막 자리에 '1'을 배치
        StringBuilder result = new StringBuilder();
        
        // 나머지 비트를 내림차순으로 배치
        for (int i = 0; i < count1 - 1; i++) {
            result.append('1');
        }
        for (int i = 0; i < count0; i++) {
            result.append('0');
        }
        result.append('1'); // 마지막 자리에 '1'을 배치
        
        return result.toString();
    }
}

/*
탐욕법은 각 단계에서 현재 상황에서 최선의 선택을 하는 방법으로, 
이 문제에서는 가장 큰 홀수 이진 숫자를 만들기 위해 각 자리에서 최선의 선택을 한다.

최대 값을 만들기 위한 최선의 선택:

마지막 자리에 '1'을 두어야 숫자가 홀수가 된다.
나머지 자리에는 '1'을 가능한 많이 앞쪽에 배치하고, 
그 뒤에 '0'을 배치하여 이진 숫자가 최대가 되도록 한다.
*/