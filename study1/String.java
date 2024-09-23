
// Solution3에 필요
import java.util.HashMap;
import java.util.HashSet;

/*
https://leetcode.com/problems/count-items-matching-a-rule/description/

1773. Count Items Matching a Rule
특정 규칙에 따라 아이템들을 필터링하여 몇 개의 아이템이 일치하는지 세는 것
*/

import java.util.*;
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index = 0;

        if(ruleKey.equals("type")){
            index = 0;
        }else if(ruleKey.equals("color")){
            index = 1;
        }else if(ruleKey.equals("name")){
            index = 2;
        }

        for(List<String> item : items){
            if(item.get(index).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}

// 배열을 순회하면서 각 아이템이 주어진 규칙에 맞는지 확인하여 해당할 때 개수를 추가한다 !



/*
https://leetcode.com/problems/shuffle-string/description/

1528. Shuffle String

문자열을 주어진 인덱스 배열에 따라 셔플하는 과정
배열을 이용해 각 문자를 적절한 위치에 배치하고, 
최종적으로 결과 배열을 문자열로 변환하여 반환하는 방식으로 문제를 해결한다. 
이 코드는 시간 복잡도가 O(n)으로, 각 문자를 한 번씩만 처리하기 때문에 효율적이게 접근할 수 있다.
*/

class Solution2 {
    public String restoreString(String s, int[] indices) {
        
        // 결과를 저장할 문자 배열 생성
        char[] result = new char[s.length()];

        // indices 배열을 순회하면서 각 문자를 적절한 위치에 배치
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

         // 문자 배열을 문자열로 변환하여 반환
        return new String(result);
    }
}

/*
https://leetcode.com/problems/decode-the-message/description/

2325. Decode the Message

암호 해독기

단계 1: 암호 해독 테이블 생성하기
먼저 key 문자열에서 각 알파벳이 처음 등장하는 순서대로 해독 테이블을 생성한다.
해독 테이블은 각 문자를 대응하는 영어 알파벳에 매핑한다.

단계 2: 메시지 해독하기
생성한 테이블을 사용하여 주어진 message를 해독한다.
공백은 그대로 유지
*/


class Solution3 {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> decodeMap = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();
        char currentChar = 'a';
        
        // Step 1: Create the substitution table
        for (char c : key.toCharArray()) {
            if (c != ' ' && !seen.contains(c)) {
                decodeMap.put(c, currentChar);
                seen.add(c);
                currentChar++;
            }
        }
        
        // Step 2: Decode the message using the table
        StringBuilder decodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                decodedMessage.append(c);
            } else {
                decodedMessage.append(decodeMap.get(c));
            }
        }
        
        return decodedMessage.toString();
    }
}

/*
HashMap 및 HashSet 초기화:

decodeMap은 문자 매핑 테이블
seen은 이미 등장한 문자를 기록한다.

암호 해독 테이블 생성:

key 문자열을 반복하면서, 각 문자가 처음 등장하면
decodeMap에 해당 문자와 현재 알파벳을 매핑하고, seen에 추가
currentChar는 'a'에서 시작해서 매핑할 다음 문자를 가리킨다.

메시지 해독:

message 문자열을 반복하면서, 
각 문자를 decodeMap을 사용하여 해독
공백은 그대로 유지

*/