
// https://school.programmers.co.kr/learn/courses/30/lessons/120834

class Solution {
    public String solution(int age) {
        
        // 스트링빌더 객체 생성
        StringBuilder answer = new StringBuilder();
        
        // 행성용 나이를 위한 알파벳 나열해놓은 문자열
        String age962 = "abcdefghij";
        
        // 매개변수로 받은 나이를
        // 문자열로 바꾼 후
        // 배열에 쪼개서 담아두기
        String[] ageArr = String.valueOf(age).split("");
        
        // 반복문 돌면서 객체에 해당 알파벳 담기
        // ex) age = 23 이면
        // ageArr = ["2","3"]
        // age962.charAt(Integer.valueOf(ageArr[0])) -> "c"
        // age962.charAt(Integer.valueOf(ageArr[1])) -> "d"
        // answer = "cd"
        for (int i = 0; i < ageArr.length; i++) {
        	answer.append(age962.charAt(Integer.valueOf(ageArr[i])));
		}
        // 문자열로 변환 후 반환
        return answer.toString();
    }
}