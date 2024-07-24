package baekjoon.day06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
자연수 N과 M이 주어졌을 때,
1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열을 모두 구하는 문제
이 수열들은 사전 순으로 증가하는 순서로 출력해야 함 

조합(combination)을 구하는 문제
-> 이를 해결하기 위해 백트래킹(backtracking) 기법 활용 가능


// 흐름

1. 초기화

주어진 N개의 자연수 중에서 M개를 고르는 모든 경우의 수를 저장할 리스트 준비

2. 백트래킹 함수 작성
- 재귀를 사용하여 수열 생성
- 수열의 길이가 M이 되면 결과 리스트에 추가하고 반환
- 현재 위치부터 N까지의 수를 하나씩 선택하여 수열 생성

3. 사전순 출력

백트래킹을 통해 생성된 모든 수열을 사전 순으로 출력

*/

public class Test1 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받은 문자열을 공백을 기준으로 분리
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 선택된 수열을 저장할 배열
        int[] sequence = new int[M];
        // 숫자의 사용 여부를 추적할 배열
        boolean[] used = new boolean[N + 1];
        // 출력을 모아서 한 번에 출력할 StringBuilder 객체 생성
        StringBuilder sb = new StringBuilder();

        // 백트래킹 시작
        backtrack(N, M, 0, sequence, used, sb);

        // 결과 출력
        System.out.print(sb.toString());
    }

    public static void backtrack(int N, int M, int depth, int[] sequence, boolean[] used, StringBuilder sb) {
        // 길이가 M인 수열이 완성되면 출력할 문자열에 추가
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지의 숫자 중 사용되지 않은 숫자를 선택
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true; // 숫자를 사용 중으로 표시
                sequence[depth] = i; // 수열에 숫자 추가
                backtrack(N, M, depth + 1, sequence, used, sb); // 다음 숫자 선택을 위해 재귀 호출
                used[i] = false; // 재귀 호출 후 숫자를 다시 사용 가능으로 표시
            }
        }
    }
}
