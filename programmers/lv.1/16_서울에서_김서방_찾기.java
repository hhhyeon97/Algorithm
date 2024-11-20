
// https://school.programmers.co.kr/learn/courses/30/lessons/12919

class Solution {
    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) { // 문자열 비교는 .equals() 사용
                return "김서방은 " + i + "에 있다";
            }
        }
        return ""; // 이 줄은 사실상 실행되지 않음/컴파일 오류 방지용
    }
}