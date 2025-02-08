

// https://leetcode.com/problems/first-unique-character-in-a-string/description/

// 중복 없는 알파벳 요소의 인덱스 반환하기

import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        // 1. 문자 빈도수 계산
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 2. 다시 순회하면서 첫 번째 고유 문자 찾기
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // 고유 문자가 없으면 -1 반환
    }
}