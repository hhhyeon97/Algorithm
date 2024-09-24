// https://www.acmicpc.net/problem/2480
// 17644KB	164ms

package baekjoon.bronze;

import java.util.Scanner;

public class 2480_주사위_세개 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dice1 = sc.nextInt();
        int dice2 = sc.nextInt();
        int dice3 = sc.nextInt();

        int result = 0;

        if (dice1 == dice2 && dice2 == dice3) {
            // 같은 눈이 3개일 때 
            result = 10000 + dice1 * 1000;
        } else if (dice1 == dice2 || dice1 == dice3) {
            // 같은 눈이 2개일 때
            result = 1000 + dice1 * 100;
        } else if (dice2 == dice3) {
            // 같은 눈이 2개일 때
            result = 1000 + dice2 * 100;
        } else {
            // 모두 다른 눈
            int max = Math.max(dice1, Math.max(dice2, dice3));
            result = max * 100;
        }

        System.out.println(result);

        sc.close();

    }
}