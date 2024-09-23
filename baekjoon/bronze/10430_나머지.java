// https://www.acmicpc.net/problem/10430
// 17668KB	172ms

package baekjoon.bronze;

import java.util.Scanner;

public class 10430_나머지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);
        /*
         * ex ) 5 8 4
         * ㄴ> 1
         *     1
         *     0
         *     0
         */

        sc.close();

    }
}