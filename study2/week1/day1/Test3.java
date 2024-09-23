package study2.week1.day1;
// https://www.acmicpc.net/problem/2530

// 인공지능 시계

// 메모리 : 18724 KB	시간 : 244 ms

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 현재 시각 입력 받기
        int currentHour = scanner.nextInt();
        int currentMinute = scanner.nextInt();
        int currentSecond = scanner.nextInt();
        
        // 요리 시간 입력 받기
        int cookingTime = scanner.nextInt();
        
        // 현재 시각을 초 단위로 변환
        int totalSeconds = currentHour * 3600 + currentMinute * 60 + currentSecond;
        
        // 요리 시간을 더한 총 시간 계산
        totalSeconds += cookingTime;
        
        // 총 시간을 시, 분, 초로 변환
        int endHour = (totalSeconds / 3600) % 24;
        int endMinute = (totalSeconds % 3600) / 60;
        int endSecond = totalSeconds % 60;
        
        // 결과 출력
        System.out.println(endHour + " " + endMinute + " " + endSecond);

        scanner.close();
    }
}