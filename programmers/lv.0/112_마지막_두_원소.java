
// https://school.programmers.co.kr/learn/courses/30/lessons/181927


// list로 풀 경우 add() 메서드로 쉽게 뒤에 원소를 추가할 수 있다.

class Solution {
    public int[] solution(int[] num_list) {
        
        int[] answer = new int[num_list.length+1];

        // 가독성 위해 
        // 마지막 원소, 마지막 원소 전 원소 변수에 담고 계산하기
        int last1 = num_list[num_list.length-1];
        int last2 = num_list[num_list.length-2]; 
        
        for(int i=0; i<num_list.length; i++){
            answer[i] = num_list[i];
        }
        
        if (last1 > last2) {
            answer[num_list.length] = last1 - last2;
        } else {
            answer[num_list.length] = last1 * 2;
        }
        
        return answer;
    }
}