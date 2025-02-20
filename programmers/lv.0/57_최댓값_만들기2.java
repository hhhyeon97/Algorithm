
// https://school.programmers.co.kr/learn/courses/30/lessons/120862

import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {

        Arrays.sort(numbers); // 정렬

        int n = numbers.length;
        
        // 음수끼리 곱한 경우도 고려해야 함
        // 가장 큰 두 수의 곱 vs 가장 작은 두 수의 곱 비교
        return Math.max(numbers[n - 1] * numbers[n - 2], numbers[0] * numbers[1]);
    }
}