
// https://school.programmers.co.kr/learn/courses/30/lessons/181921

import java.util.*;
class Solution {
    public List<Integer> solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            String s = String.valueOf(i);
            boolean isValid = true;
            for (char c : s.toCharArray()) {
                if (c != '0' && c != '5') {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        return list;
    }
}