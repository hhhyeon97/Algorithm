
// https://leetcode.com/problems/reverse-vowels-of-a-string/description/

class Solution {
    public String reverseVowels(String s) {

        // 문자열을 문자 배열로 변환
        char[] chars = s.toCharArray();
        
        // 모음 체크용 문자열
        String vowels = "aeiouAEIOU";
        
        // 두 포인터
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // 왼쪽 포인터가 모음이 아닌 경우 이동
            while (left < right && vowels.indexOf(chars[left]) == -1) {
                left++;
            }
            // 오른쪽 포인터가 모음이 아닌 경우 이동
            while (left < right && vowels.indexOf(chars[right]) == -1) {
                right--;
            }
            // 두 모음을 교환
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // 포인터 이동
            left++;
            right--;
        }
        /* ex )
        
        Input : s = "IceCreAm"
        chars = ['I', 'c', 'e', 'C', 'r', 'e', 'A', 'm']
        모음 : ['I', 'e', 'e', 'A']
        뒤집기 후 : ['A', 'e', 'e', 'I']
        
        결과 : "AceCreIm"
        */

        // 문자 배열을 문자열로 변환
        return new String(chars);
    }
}
