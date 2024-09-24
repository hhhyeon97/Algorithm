// https://www.acmicpc.net/problem/1924
// 17672KB	164ms

package baekjoon.bronze;

import java.util.Scanner;

public class 1924_2007년 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); // 월 입력 
        int y = sc.nextInt(); // 일 입력

        // ex) 3월 14일 ! 

        // 각 달의 일수 배열 (1월 ~ 12월)
        // 1월은 31일, 2월은 28일, 3월은 31일, ..., 12월은 31일
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // totalDays: 1월 1일부터 계산한 총 일수
        int totalDays = 0;

        // 입력 받은 달 이전까지의 일수를 모두 더한다.
        // 즉, 1월과 2월의 일수를 더함.
        for (int i = 0; i < x - 1; i++) {
            totalDays += daysInMonth[i];
        }
        // 예시: 3월 14일의 경우
        // 1월의 일수: 31일, 2월의 일수: 28일
        // totalDays = 31 + 28 = 59

        // 그 달의 입력받은 일수를 더해준다.
        totalDays += y;
        // 3월 14일이므로 totalDays = 59 + 14 = 73

        // 요일 배열 (2007년 1월 1일은 월요일부터 시작)
        String[] daysOfWeek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        // 요일 결정: 총 일수에서 1을 뺀 후 7로 나눈 나머지를 이용
        String resultDay = daysOfWeek[(totalDays - 1) % 7];
        // (73 - 1) % 7 = 72 % 7 = 2
        // 요일 배열에서 index 2는 "WED" (수요일)

        // 결과 출력
        System.out.println(resultDay);

        sc.close();
    }
}