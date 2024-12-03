
// https://school.programmers.co.kr/learn/courses/30/lessons/12940

public class Solution {
    public static int[] solution(int n, int m) {
        int gcd = getGCD(n, m); // 최대공약수 계산
        int lcm = (n * m) / gcd; // 최소공배수 계산
        return new int[] {gcd, lcm};
    }

    // 최대공약수를 구하는 함수 (유클리드 호제법)
    /*
    getGCD 메서드 설명
    ㄴ 유클리드 호제법을 사용해 GCD를 계산.
    ㄴ 큰 수와 작은 수를 나눈 나머지를 계속 업데이트하여 
       나머지가 0이 되는 순간의 값이 GCD.
     */
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}