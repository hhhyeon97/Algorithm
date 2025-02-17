
// https://school.programmers.co.kr/learn/courses/30/lessons/120839


// 각 문자(2, 0, 5)를 이길 수 있는 값으로 치환하는 문제
// ㄴ 2 → 0, 0 → 5, 5 → 2로 변환 하면 된다.
class Solution {
    public String solution(String rsp) {

        StringBuilder result = new StringBuilder();
        
        // 문자열을 문자 배열로 만들어서 반복문 돌리기
        for (char ch : rsp.toCharArray()) {
            if (ch == '2') {
                result.append('0'); // 가위(2) → 바위(0)
            } else if (ch == '0') {
                result.append('5'); // 바위(0) → 보(5)
            } else if (ch == '5') {
                result.append('2'); // 보(5) → 가위(2)
            }
        }
        
        // 빌더 객체를 문자열로 변환하여 반환
        return result.toString();
    }
}