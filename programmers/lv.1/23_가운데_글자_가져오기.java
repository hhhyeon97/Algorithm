
// https://school.programmers.co.kr/learn/courses/30/lessons/12903

// substring(a,b)가 a는 포함 b는 포함 x !!

/*
substring(beginIndex, endIndex)

beginIndex: 포함되는 시작 인덱스.
endIndex: 포함되지 않는 끝 인덱스.

시간 복잡도
ㄴ O(1): 문자열 길이 확인과 인덱스 계산만 수행

*/
class Solution {
    public String solution(String s) {
        
        int len = s.length();
        
        if (len % 2 == 0) {
            // 길이가 짝수일 경우 가운데 두 글자 반환
            return s.substring(len / 2 - 1, len / 2 + 1); // substring은 끝 인덱스 미포함
        } else {
            // 길이가 홀수일 경우 가운데 한 글자 반환
            return s.substring(len / 2, len / 2 + 1);
        }
        
    }
}