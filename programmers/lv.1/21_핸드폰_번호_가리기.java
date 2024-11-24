
// https://school.programmers.co.kr/learn/courses/30/lessons/12948

// 번호 길이를 토대로 뒷4자리 추출 + 마스킹한 문자열을 합친다.
class Solution {
    public String solution(String phone_number) {
        // 전화번호 길이
        int length = phone_number.length();
        
        // 뒷 4자리 추출
        String lastFour = phone_number.substring(length - 4);
        
        // 앞 부분을 '*'로 채우기
        String masked = "*".repeat(length - 4);
        
        // 결합하여 반환
        return masked + lastFour;
    }
}