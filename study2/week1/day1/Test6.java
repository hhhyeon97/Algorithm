package study2.week1.day1;
// https://www.acmicpc.net/problem/1924

// 2007년 - > 주어진 날짜가 2007년 1월 1일(월요일)부터 몇 일째인지를 계산하여 
// 입력 받은 날짜가 무슨 요일인지 알아내기

// 메모리 : 17728 KB	시간 : 216 ms

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        // 각 달의 일수 배열 (1월부터 12월까지)
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // 2007년 1월 1일이 월요일이므로 이를 기준으로 일수를 계산
        int totalDays = 0;

        // 입력 받은 달 이전까지의 일수를 더함
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        // 입력 받은 달의 일수를 더함
        totalDays += day;

        // 요일 배열
        String[] daysOfWeek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        // 2007년 1월 1일이 월요일이므로 나머지를 계산하여 요일 결정
        String resultDay = daysOfWeek[(totalDays - 1) % 7];

        // 결과 출력
        System.out.println(resultDay);

        scanner.close();
    }
}