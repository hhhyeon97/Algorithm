// https://www.acmicpc.net/problem/24313

// 메모리 :  17716 KB	시간 : 212 ms

package baekjoon.day06;

import java.util.Scanner;

/*
함수 f(n) = a1n + a0가 O(n) 정의를 만족하는지 확인해야 함
-> 주어진 n0 이후 모든 n에 대해 f(n) ≤ c × n이 되어야 함

조건을 만족하지 않는 경우가 하나라도 있으면 0, 모두 만족하면 1 출력
*/
public class Test2 {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 함수 f(n)의 계수 a1, a0 입력 받기
        int a1 = scanner.nextInt();
        int a0 = scanner.nextInt();

        // 양의 정수 c 입력 받기
        int c = scanner.nextInt();

        // 양의 정수 n0 입력 받기
        int n0 = scanner.nextInt();

        // 결과를 저장할 변수 result 초기화
        int result = 1; // 기본값은 1로 설정 (만족한다고 가정)

        // n0부터 100까지 확인
        for (int n = n0; n <= 100; n++) {
            // f(n) = a1 * n + a0 계산
            int fn = a1 * n + a0;
            // c * n 계산
            int cn = c * n;

            // 조건을 만족하지 않으면 결과를 0으로 설정하고 종료
            if (fn > cn) {
                result = 0;
                break;
            }
        }
        // 결과 출력
        System.out.println(result);

        scanner.close();
    }
}