
// https://leetcode.com/problems/ransom-note/description/

/*
ransomNote의 각 문자가 
magazine에 필요한 개수만큼 포함되어 있는지 확인하기
ㄴ HashMap 사용 : 각 문자의 빈도를 저장하고 비교하는 방식으로 접근
*/

import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        // magazine의 문자 카운팅
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // ransomNote의 문자 필요 개수 확인
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false; // 문자가 없거나/사용할 수 있는 개수가 부족한 경우
            }
            charCount.put(c, charCount.get(c) - 1); // 사용 후 개수 감소
        }

        /* ex )
        ransomNote = "aa", magazine = "aab"
        charCount 초기값 : {a=2, b=1}
        1번째 문자 : 'a' → 개수 줄임 → {a=1, b=1}
        2번째 문자 : 'a' → 개수 줄임 → {a=0, b=1}
        모든 문자 확인 완료 → true
        */
        return true; // 모든 문자를 사용할 수 있는 경우
    }
}