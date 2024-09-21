

// https://school.programmers.co.kr/learn/courses/30/lessons/12944

class Solution {
    public double solution(int[] arr) {
        // 배열 원소들의 합을 구할 변수 선언
        int sum = 0;
        
        // 배열을 순회하면서 모든 원소들의 합을 구함
        for (int num : arr) {
            sum += num;
        }
        
        // 배열 원소들의 합을 배열의 길이로 나누어 평균을 반환
        return (double) sum / arr.length;
    }
}