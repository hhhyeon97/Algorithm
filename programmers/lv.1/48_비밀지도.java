
// https://school.programmers.co.kr/learn/courses/30/lessons/17681

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        // 비밀지도 해독한 결과 담을 문자열 배열
        String[] map = new String[n];
        
        for (int i = 0; i < n; i++) {
            // 각 줄에 대해 OR 연산 수행 : 두 지도 정보 결합
            int combined = arr1[i] | arr2[i];
            // 결합 결과를 이진수 문자열로 변환 + n 길이 맞추기
            String binaryString = String.format("%" + n + "s", Integer.toBinaryString(combined));
            // 이진수를 #과 공백으로 변환
            map[i] = binaryString.replace('1', '#').replace('0', ' ');
        }
        
        return map;
    }
}