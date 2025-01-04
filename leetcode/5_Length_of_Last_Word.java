
// https://leetcode.com/problems/length-of-last-word/description/

class Solution {
    public int lengthOfLastWord(String s) {
       
        // 양 끝 공백 제거
        s = s.trim();

        // 공백을 기준으로 단어 분리
        String[] words = s.split(" ");

        // 마지막 단어의 길이 반환
        return words[words.length - 1].length();
    }
}