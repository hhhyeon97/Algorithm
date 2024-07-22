// https://www.acmicpc.net/problem/24267

/*
MenOfPassion(A[], n) {
    sum <- 0;
    for i <- 1 to n - 2
        for j <- i + 1 to n - 1
            for k <- j + 1 to n
                sum <- sum + A[i] × A[j] × A[k]; # 코드1
    return sum;
}
*/

// 주어진 MenOfPassion 알고리즘 - > 삼중 루프를 사용해서 배열의 세 원소를 곱한 값을 더하는 방식

// 메모리 :  14248 KB 시간 : 124 ms

package baekjoon.day5;

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());

        // n에 대한 삼중 루프의 모든 경우의 수를 구하는 식
        System.out.println(n * (n - 1) * (n - 2) / 6);
        // 알고리즘의 시간복잡도가 O(n^3)이므로 최고차항의 차수는 3
        System.out.println(3);
    }
}