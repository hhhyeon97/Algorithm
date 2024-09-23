package study2.week1.study;

import java.util.Scanner;

// 재귀 호출 연습

// https://www.acmicpc.net/problem/10870
// 피보나치 수 5


public class 재귀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = fibo(n);
        System.out.println(result);
    }
    static int fibo(int n) {
        // 기저 조건 셋팅
        // n == 0 - > 0
        // n == 1 - > 1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {    // 재귀 호출
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
