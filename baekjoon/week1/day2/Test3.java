package baekjoon.week1.day2;
// https://www.acmicpc.net/problem/2445

// 별 찍기 - 8

// 메모리 : 21604 KB	시간 : 588 ms

import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int totalLines = 2 * N - 1;

        for (int i = 1; i <= totalLines; i++) {
            if (i <= N) { // 윗부분
                printStarsAndSpaces(i, N);
            } else { // 아랫부분
                printStarsAndSpaces(totalLines - i + 1, N);
            }
        }
    }

    private static void printStarsAndSpaces(int i, int N) {
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }
        for (int j = 1; j <= 2 * (N - i); j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}


// 루프의 중첩을 피한 버전 - > StringBuilder 사용하기 - >
// 문자열을 효율적으로 생성한 후, 한 번에 출력

// 메모리 : 15044 KB	시간 : 152 ms

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        int N = Integer.parseInt(br.readLine());
        // 총 출력할 라인 수 계산
        int totalLines = 2 * N - 1;

        // 각 줄에 대해 처리
        for (int i = 0; i < totalLines; i++) {
            // 현재 줄에서 출력할 별의 수 계산
            int stars = i < N ? i + 1 : totalLines - i;
            // 현재 줄에서 출력할 공백의 수 계산
            int spaces = 2 * (N - stars);

            // 줄 출력
            printLine(stars, spaces);
        }
    }

    // 한 줄을 생성하여 출력하는 메서드
    private static void printLine(int stars, int spaces) {
        StringBuilder sb = new StringBuilder();

        // 왼쪽 별 출력
        for (int j = 0; j < stars; j++) {
            sb.append('*');
        }
        // 가운데 공백 출력
        for (int j = 0; j < spaces; j++) {
            sb.append(' ');
        }
        // 오른쪽 별 출력
        for (int j = 0; j < stars; j++) {
            sb.append('*');
        }

        // 생성한 줄 출력
        System.out.println(sb.toString());
    }