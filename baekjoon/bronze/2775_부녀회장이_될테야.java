// https://www.acmicpc.net/problem/2775
// 17596KB	180ms

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); // 테스트 케이스 수
        
        // 최대 k와 n의 크기
        int maxK = 14;
        int maxN = 14;

        // dp 배열 초기화
        int[][] dp = new int[maxK + 1][maxN + 1];

        // 0층 초기화 (0층의 i호에는 i명이 산다)
        for (int i = 1; i <= maxN; i++) {
            dp[0][i] = i;
        }

        // dp 배열 채우기
        for (int k = 1; k <= maxK; k++) {
            for (int n = 1; n <= maxN; n++) {
                dp[k][n] = dp[k - 1][n]; // (k-1층)의 n호
                if (n > 1) {
                    dp[k][n] += dp[k][n - 1]; // (k층)의 (n-1호)와 합산
                }
            }
        }

        // 각 테스트 케이스에 대해 결과 출력
        for (int i = 0; i < T; i++) {
            int k = scan.nextInt();
            int n = scan.nextInt();
            System.out.println(dp[k][n]);
        }
        
        scan.close();
    }
}