
// https://leetcode.com/problems/valid-anagram/

// 두 문자열이 같은 문자들을 같은 개수로 가지고 있으면 true

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false; // 길이가 다르면 false
        
        // 두 문자열을 char[]로 변환한 후 정렬
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        // 정렬 후 문자열이 같으면 애너그램
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        return Arrays.equals(sArray, tArray);
    }
}