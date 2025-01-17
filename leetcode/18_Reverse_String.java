
// https://leetcode.com/problems/reverse-string/description/

// 조건
// 추가 배열을 생성하지 않고, 기존 배열 내에서 교환 작업만 수행
// ㄴ in-place 방식: 새로운 배열을 사용하지 않고 기존 배열을 수정

class Solution {
    public void reverseString(char[] s) {

        // left와 right 포인터 활용 -> 배열의 양 끝에서부터 접근
        int left = 0;
        int right = s.length - 1;

        // 두 포인터가 교차할 때까지 요소를 교환하며 이동
        // 최종적으로 입력 배열 자체가 뒤집힘
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}