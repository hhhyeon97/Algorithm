package baekjoon.week1.day1;
// https://www.acmicpc.net/problem/2480

// 주사위 3개 - > 주사위 눈에 따라 적절한 상금을 계산하고 출력하는 문제

// 메모리 : 17676 KB	시간 : 216 ms

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 주사위 눈 입력 받기
        int dice1 = scanner.nextInt();
        int dice2 = scanner.nextInt();
        int dice3 = scanner.nextInt();
        
        int prize = 0;
        
        if (dice1 == dice2 && dice2 == dice3) {
            // 같은 눈이 3개
            prize = 10000 + dice1 * 1000;
        } else if (dice1 == dice2 || dice1 == dice3) {
            // 같은 눈이 2개
            prize = 1000 + dice1 * 100;
        } else if (dice2 == dice3) {
            // 같은 눈이 2개
            prize = 1000 + dice2 * 100;
        } else {
            // 모두 다른 눈
            int max = Math.max(dice1, Math.max(dice2, dice3));
            prize = max * 100;
        }
        
        // 결과 출력
        System.out.println(prize);

        scanner.close();
    }
}