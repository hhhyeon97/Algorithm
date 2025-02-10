
// https://school.programmers.co.kr/learn/courses/30/lessons/120849

class Solution {
    public String solution(String my_string) {
        
        String answer = my_string;
        
        // 모음 담은 배열 만들기
        String[] vowels = {"a", "e", "i", "o", "u"};
        
        // 모음 제거
        // replaceAll("찾을 문자열", "바꿀 문자열")
        // "바꿀 문자열" 자리에 ""를 넣어주면 문자가 삭제 됨
        for (String v : vowels) {
            answer = answer.replaceAll(v, "");
        }
        
        return answer;
    }
}