
// https://leetcode.com/problems/longest-common-prefix/

import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {

    // 주어진 문자열 배열에서 가장 긴 공통 접두사를 찾아 반환하기    

    if (strs == null || strs.length == 0) return ""; // 예외 처리

    Arrays.sort(strs); // 배열 정렬
    
    String first = strs[0]; // 첫 번째 문자열
    String last = strs[strs.length - 1]; // 마지막 문자열
    
    int i = 0;
    
    while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
        i++;
    }
    
    return first.substring(0, i); // 공통 접두사 반환
    
    }
}