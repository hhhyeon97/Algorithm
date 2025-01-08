
// https://leetcode.com/problems/excel-sheet-column-number/

// 엑셀 열 제목 - 26진법처럼 동작
class Solution {
    public int titleToNumber(String columnTitle) {

        int result = 0;
        
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            int value = ch - 'A' + 1; // 문자 값을 숫자로 변환
            result = result * 26 + value; // 26진법 계산
        }
        /*
        예시 )
        입력 : columnTitle = "AB"
        A -> 1
        B -> 2
        0 * 26 + 1 = 1
        1 * 26 + 2 = 28
        출력 : 28
        */
        return result;
    }
}