

// https://school.programmers.co.kr/learn/courses/30/lessons/120905

import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] numlist) {
        // ArrayList를 사용하여 동적으로 값을 추가
        ArrayList<Integer> list = new ArrayList<>();
        
        // numlist 배열을 순회하며 n의 배수를 ArrayList에 추가
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                list.add(numlist[i]);
            }
        }
        
        // ArrayList를 int[] 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}