// https://www.acmicpc.net/problem/1914
// 하노이 탑

package baekjoon.test1;

import java.io.*;

public class Test3 {
    // 이동 횟수를 저장할 변수
    static int moveCount = 0;
    // 이동 과정을 저장할 변수
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // 첫 번째 장대에 쌓인 원판의 개수 N 
       int N = Integer.parseInt(br.readLine());

        // 하노이의 탑 이동을 시작
        // N: 원판의 개수
        // 1: 시작 장대
        // 3: 목표 장대
        // 2: 보조 장대
        // N이 20 이하인 경우에만 이동 과정을 저장
        hanoi(N, 1, 3, 2, N <= 20);

        // 총 이동 횟수를 출력
        System.out.println(moveCount);

        // N이 20 이하인 경우에만 이동 과정을 출력
        if (N <= 20) {
            System.out.println(result.toString());
        }
    }

    // 하노이의 탑 알고리즘 - > 재귀로 구현
    public static void hanoi(int n, int from, int to, int aux, boolean shouldPrint) {
        if (n == 1) {
            // 원판이 하나일 경우, 단순히 목표 장대로 이동
            move(from, to, shouldPrint);
            return;
        }

        // n-1개의 원판을 보조 장대로 이동
        hanoi(n - 1, from, aux, to, shouldPrint);
        // 가장 큰 원판을 목표 장대로 이동
        move(from, to, shouldPrint);
        // 보조 장대에 있는 n-1개의 원판을 목표 장대로 이동
        hanoi(n - 1, aux, to, from, shouldPrint);
    }

    // 원판을 이동하는 함수
    public static void move(int from, int to, boolean shouldPrint) {
        // 이동 횟수를 증가시킴
        moveCount++;
        // 이동 과정을 저장할지 여부를 확인
        if (shouldPrint) {
            // 이동 과정을 StringBuilder에 추가
            result.append(from).append(" ").append(to).append("\n");
        }
    }
}