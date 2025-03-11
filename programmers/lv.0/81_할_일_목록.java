
// https://school.programmers.co.kr/learn/courses/30/lessons/181885


import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        
        List<String> resultList = new ArrayList<>();
        for(int i=0; i<finished.length; i++){
            if(!finished[i]){
                resultList.add(todo_list[i]);
            }
        }
        String[] result = new String[resultList.size()];
        return resultList.toArray(result);
    }
}
