
// https://school.programmers.co.kr/learn/courses/30/lessons/181928


// 홀수끼리 이어 붙인 값이랑 짝수끼리 이어 붙인 값의 합 구하기

class Solution {
    public int solution(int[] num_list) {
        
        StringBuilder even = new StringBuilder(); // 짝수
        StringBuilder odd = new StringBuilder();  // 홀수

        // 이어 붙인 문자열 만들기
        for (int n : num_list) {
            if (n % 2 == 0) {
                even.append(n);
            } else {
                odd.append(n);
            }
        }

        // 빌더 객체를 문자열로 바꿈 -> 문자열을 최종 정수로 바꾸기
        int sum = Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());
        
        return sum;
    }
}