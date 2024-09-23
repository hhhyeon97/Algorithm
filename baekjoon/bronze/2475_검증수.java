// https://www.acmicpc.net/problem/2475
// 17640KB	168ms

package baekjoon.bronze;


import java.util.Scanner;

public class 2475_검증수 {
    public static void main(String[] args) {
        int num[] = new int[5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += num[i] * num[i];
        }

        int result = sum % 10;

        System.out.println(result);
        sc.close();

    }
}