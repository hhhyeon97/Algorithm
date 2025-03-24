
// https://school.programmers.co.kr/learn/courses/30/lessons/181868

/*
trim() 메서드 - 문자열 앞 뒤 공백 제거
split("\\s+") 메서드 - 연속된 공백을 하나의 구분자로 처리하여 문자열을 분할

배운 점: split(" ")은 연속된 공백을 그대로 남기는데
split("\\s+")은 여러 개의 공백도 하나로 인식하여 분리할 수 있음!
*/

class Solution {
    public String[] solution(String my_string) {
        String[] answer = my_string.trim().split("\\s+");
        return answer;
    }
}
