// https://www.acmicpc.net/problem/24417
// 알고리즘 수업 - 피보나치 수 2

// 피보나치 수를 계산하는 두 가지 방법과 각 방법의 실행 횟수를 계산하는 문제

// 메모리 :  KB	시간 :  ms


package baekjoon.day3;


import java.io.*;

public class Test2 {

    // 코드1과 코드2에서 호출 횟수를 카운트하는 변수
    static int count1; // 재귀 호출 횟수
    static int count2; // 동적 프로그래밍의 반복문 실행 횟수

    // 동적 프로그래밍을 위한 배열
    static int[] f;

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 읽기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값 읽기
        int num = Integer.parseInt(br.readLine());

        // 배열 초기화
        f = new int[num + 1]; // 배열 크기 조정 (f[0]은 사용하지 않음)

        // 카운트 변수 초기화
        count1 = 0;
        count2 = 0;

        // 재귀 호출을 이용하여 피보나치 수 계산 (재귀 호출 횟수 카운트)
        fib(num);

        // 동적 프로그래밍을 이용하여 피보나치 수 계산 (반복문 횟수 카운트)
        fibbonacci(num);

        // 결과 출력
        System.out.println(count1 + " " + count2);
    }

    // 피보나치 수를 재귀적으로 계산
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++; // 코드1의 호출 횟수 증가
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 동적 프로그래밍을 이용하여 피보나치 수 계산
    static int fibbonacci(int n) {
        // 기본값 설정
        f[1] = 1;
        if (n > 1)
            f[2] = 1;

        // 피보나치 수를 반복문을 통해 계산
        for (int i = 3; i <= n; i++) {
            count2++; // 코드2의 반복문 횟수 증가
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
