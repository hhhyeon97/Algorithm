package baekjoon.week1.day3;
// https://www.acmicpc.net/problem/24416
// 알고리즘 수업 - 피보나치 수 1

// 메모리 : 16112 KB	시간 : 508 ms


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test1 {

    // 코드1, 코드2의 실행 횟수를 저장할 변수
    static int code1Cnt, code2Cnt;

    // 동적 프로그래밍에서 사용할 배열
    static int[] f;

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 값(n)을 읽어서 정수로 변환
        int n = Integer.parseInt(br.readLine());
        // 동적 프로그래밍에서 사용할 배열 초기화 (크기는 n)
        f = new int[n];

        // 입력 스트림 닫기
        br.close();

        // 카운트 변수 초기화
        code1Cnt = 0;
        code2Cnt = 0;

        // 재귀 호출 방식으로 피보나치 수 계산 (실행 횟수 카운트)
        fib(n);
        // 동적 프로그래밍 방식으로 피보나치 수 계산 (실행 횟수 카운트)
        fibonacci(n);

        // 코드1과 코드2의 실행 횟수 출력
        System.out.println(code1Cnt + " " + code2Cnt);
    }

    // 재귀 호출을 이용한 피보나치 계산 메서드
    static int fib(int n) {
        // n이 1 또는 2일 경우, 피보나치 수는 1
        if (n == 1 || n == 2) {
            // 코드1이 실행된 횟수 증가
            code1Cnt++;
            return 1;
        } else {
            // n이 1 또는 2가 아닌 경우, 재귀 호출로 피보나치 수 계산
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 동적 프로그래밍을 이용한 피보나치 계산 메서드
    static int fibonacci(int n) {
        // 초기 피보나치 수 설정 (f[0] = 1, f[1] = 1)
        f[0] = 1;
        f[1] = 1;

        // 3번째 피보나치 수부터 n번째 피보나치 수까지 계산
        for (int i = 2; i < n; i++) {
            // 코드2가 실행된 횟수 증가
            code2Cnt++;
            // 현재 피보나치 수는 이전 두 피보나치 수의 합
            f[i] = f[i - 1] + f[i - 2];
        }
        // n번째 피보나치 수 반환 (배열은 0부터 시작하므로 f[n-1])
        return f[n - 1];
    }
}