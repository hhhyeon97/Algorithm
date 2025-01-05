
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution {
    public int strStr(String haystack, String needle) {
        
        // needle의 길이가 더 크면 바로 -1 반환
        if (needle.length() > haystack.length()) {
            return -1;
        }

        // haystack에서 needle 길이만큼 서브스트링 비교 -> 탐색 범위를 줄인다.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // 부분 문자열이 needle과 일치하면 해당 인덱스 반환
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        // 일치하는 부분이 없으면 -1 반환
        return -1;
    }
}