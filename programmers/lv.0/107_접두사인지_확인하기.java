
// https://school.programmers.co.kr/learn/courses/30/lessons/181906

// startWith() 
// 문자열 포함 여부 확인 메서드
// 특정 문자열로 시작하는지 체크함
// boolean 타입으로 반환

class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        
        if(my_string.startsWith(is_prefix)){
            answer = 1;
        }
        
        return answer;
    }
}