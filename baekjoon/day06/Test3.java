package baekjoon.day06;

/*
자연수 N과 M이 주어졌을 때, 1부터 N까지의 자연수 중에서 중복 없이 
M개를 고른 수열을 구하는 것
이 수열은 오름차순이어야 하며, 사전 순으로 출력되어야 한다.
- > 백트래킹(backtracking) 기법 사용
*/

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);
        // 자연수 N과 M 입력 받기
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();

        // 선택된 수열을 저장할 배열
        int[] sequence = new int[M];

        // 백트래킹 시작
        backtrack(N, M, 0, 1, sequence);
    }

    public static void backtrack(int N, int M, int depth, int start, int[] sequence) {
        // 길이가 M인 수열이 완성되면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        // start부터 N까지의 숫자 중 사용되지 않은 숫자를 선택
        for (int i = start; i <= N; i++) {
            sequence[depth] = i; // 수열에 숫자 추가
            backtrack(N, M, depth + 1, i + 1, sequence); // 다음 숫자 선택을 위해 재귀 호출
        }
    }
}

/*

1. 입력 받기

Scanner 객체를 사용하여 사용자로부터 자연수 N과 M을 입력 받기

2. 초기 설정

sequence 배열을 사용하여 선택된 수열을 저장

3. 백트래킹 함수

depth는 현재 수열의 길이
start는 다음 숫자를 선택할 시작 위치
depth가 M이 되면 현재 수열을 출력
그렇지 않으면 start부터 N까지의 숫자 중에서 
사용되지 않은 숫자를 선택하여 재귀 호출을 통해 수열을 만든다.

- > 결론 : 자연수 N과 M이 주어졌을 때, 
조건을 만족하는 모든 수열을 오름차순으로 출력하이소...
*/