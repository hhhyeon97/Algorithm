package study2.week1.day1;
// https://www.acmicpc.net/problem/2475

// 검증수

// 메모리 : 17604 KB	시간 : 172 ms

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 각 숫자를 제곱한 후 합산
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += numbers[i] * numbers[i];
        }

        // 검증수 계산
        int result = sum % 10;

        // 결과 출력
        System.out.println(result);

        scanner.close();
    }
}