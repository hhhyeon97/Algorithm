// https://www.acmicpc.net/problem/2530
// 18712KB	204ms

package baekjoon.bronze;


import java.util.Scanner;

public class 2530_인공지능_시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 시간
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int second = sc.nextInt();

        // 요리에 걸리는 시간
        int cookingTime = sc.nextInt();

        // 현재 시간을 초로 바꾸기
        int totalSeconds = hour * 3600 + minute * 60 + second;
        /*
         * ex)
         * 14 30 0
         * (14 * 3600) + (30 * 60) + 0 = 50400 + 1800 + 0 = 52200초
         */

        // 요리 걸리는 시간까지 포함한 총 시간
        totalSeconds += cookingTime;
        /*
         * ex)
         * 200
         * 52200초 + 200초 = 52400초
         */

        // 총 시간을 다시 시, 분, 초로 변경하기
        int endHour = (totalSeconds / 3600) % 24;
        int endMinute = (totalSeconds % 3600) / 60;
        int endSecond = totalSeconds % 60;
        /*
         * 1) 시간을 계산:
         * 52400 / 3600 = 14 → 14시간 (몫)
         * 2) 남은 초에서 분을 계산:
         * 52400 % 3600 = 200 → 200초 남음
         * 200 / 60 = 3 → 3분 (몫) (기존 분에 더하기)
         * 3) 나머지 초 계산:
         * 200 % 60 = 20 → 20초 (나머지)
         * ㄴ> 14시 33분 20초
         */

        // 결과 출력
        // 14 33 20
        System.out.println(endHour + " " + endMinute + " " + endSecond);

        sc.close();

    }
}