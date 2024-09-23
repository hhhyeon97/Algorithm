package study2.week1.day2;
// https://www.acmicpc.net/problem/2438

// 별 찍기 - 1

// 메모리 : 14884 KB	시간 : 228 ms

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        N = Integer.parseInt(br.readLine());
        // 이중 for문 사용
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}