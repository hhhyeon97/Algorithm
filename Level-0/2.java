// 두 수의 나눗셈

class Solution {
    public int solution(int num1, int num2) {
        // num1을 num2로 나눈 후 1,000을 곱한 값을 계산
        double result = (double) num1 / num2 * 1000;
        
        // 정수 부분만 반환
        return (int) result;
    }
}
