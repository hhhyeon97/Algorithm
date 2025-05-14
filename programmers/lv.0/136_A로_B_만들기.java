
// https://school.programmers.co.kr/learn/courses/30/lessons/120886


import java.util.*;
class Solution {
    public int solution(String before, String after) {
        
        char[] arr1 = before.toCharArray();
        char[] arr2 = after.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        String s1 = new String(arr1);
        String s2 = new String(arr2);
        
        return s1.equals(s2) ? 1 : 0;
    }
}