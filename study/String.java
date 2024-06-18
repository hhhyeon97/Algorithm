

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