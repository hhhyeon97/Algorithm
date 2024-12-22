
// https://school.programmers.co.kr/learn/courses/30/lessons/12951

/*
문자열에 연속된 공백도 존재할 수 있는 문제라서 split 대신
문자열 전체를 한 문자씩 순회/공백 여부와 첫 문자인지 확인하는 방식으로 접근
공백은 그대로 추가하고, 문자는 대소문자로 변환하여 추가하여 결과 문자열 만들기 !
*/
class Solution {
    public String solution(String s) {

        StringBuilder answer = new StringBuilder(); // 결과를 담을 StringBuilder 객체
        // StringBuilder는 가변 객체라서
        // 문자열을 추가하거나 수정할 때도 새로운 객체를 만들지 않고
        // 내부 버퍼를 재사용하기 때문에 문자열 자주 조작하는 문제에서 자주 사용됨

        boolean isStartOfWord = true; // 단어의 첫 문자인지 체크하는 플래그

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i); // 현재 문자

            if (c == ' ') {
                // 공백인 경우
                answer.append(c);
                isStartOfWord = true; // 다음 문자는 단어의 첫 문자
            } else {
                // 공백이 아닌 경우
                if (isStartOfWord) {
                    answer.append(Character.toUpperCase(c)); // 단어 첫 문자 대문자
                } else {
                    answer.append(Character.toLowerCase(c)); // 나머지 소문자
                }
                isStartOfWord = false; // 첫 문자 처리 완료
            }
        }

        // 빌더 객체를 문자열로 변환하여 반환
        return answer.toString();
    }
}