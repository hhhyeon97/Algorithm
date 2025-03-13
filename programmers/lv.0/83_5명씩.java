
// https://school.programmers.co.kr/learn/courses/30/lessons/181886

import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> list = new ArrayList<>();

        // 5명씩 묶은 그룹의 맨 앞 사람 이름 담기 
        // 나머지 그룹이 완전히 되지 않아도 맨 앞 사람 이름 담겨야 함
        for(int i=0; i<names.length; i+=5){
            list.add(names[i]);
        }
        
        String[] result = new String[list.size()];
        
        // 리스트 -> 배열로 변환 후 반환하기
        return list.toArray(result);
    }
}
