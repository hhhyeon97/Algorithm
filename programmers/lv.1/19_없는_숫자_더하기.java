
// https://school.programmers.co.kr/learn/courses/30/lessons/86051

class Solution {
    public int solution(int[] numbers) {

        // 0~9까지를 모두 더한 값 : 45
        int sum = 45;
        // 45에서 numbers의 원소값들을 빼준다.
        for (int i : numbers) {
            sum -= i;
        }
        return sum;      
    }
}