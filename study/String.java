

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