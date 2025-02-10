
// https://leetcode.com/problems/is-subsequence/description/

class Solution {
    public boolean isSubsequence(String s, String t) {

        // 투포인터 접근
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;  // s의 다음 문자 확인
            }
            j++;  // t의 다음 문자 확인
        }
        // s를 끝까지 탐색했다면 true
        return i == s.length(); 
    }
}
