// https://www.acmicpc.net/problem/9184

/*
재귀 함수 w(a, b, c)를 구현하는 문제
재귀 호출이 매우 많이 발생할 수 있기 때문에 
메모이제이션을 사용하여 이미 계산된 값을 저장 - >시간 절약하기
- > 중복 계산을 피할 수 있음 !

기저 조건:
a, b, c 중 하나라도 0 이하이면 1을 반환.
a, b, c 중 하나라도 20을 초과하면 w(20, 20, 20)을 반환.
a < b < c이면 w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)을 반환.
그 외의 경우 w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)을 반환.

*/


// 메모리 : 27056 KB	시간 : 304 ms

package baekjoon.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {
    // 메모이제이션을 위한 3차원 배열 선언
    // dp[i][j][k]는 w(i, j, k)의 값을 저장한다.
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 빠르게 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder를 사용하여 출력 문자열을 효율적으로 만들기
        StringBuilder sb = new StringBuilder();

        while (true) {
            // 한 줄씩 입력을 받아 공백을 기준으로 분리
            String[] input = br.readLine().split(" ");
            // 입력된 세 정수를 각각 a, b, c에 저장
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            // 입력이 "-1 -1 -1"인 경우, 반복문 종료
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            // w(a, b, c)를 계산하고 결과를 StringBuilder에 추가
            // 결과는 "w(a, b, c) = 결과" 형식으로 저장
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
        }

        // StringBuilder에 저장된 모든 결과를 출력
        System.out.print(sb.toString());
    }

    // 재귀적으로 w(a, b, c)를 계산하는 함수
    public static int w(int a, int b, int c) {
        // 기저 조건: a, b, c 중 하나라도 0 이하일 때 1을 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 기저 조건: a, b, c 중 하나라도 20을 초과할 때 w(20, 20, 20)으로 처리
        // 모든 입력이 20을 넘을 경우에도 같은 결과를 보장
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 메모이제이션: 이미 계산된 값이 있는 경우 그 값을 반환
        // dp[a][b][c]가 0이 아닌 경우는 이미 계산된 결과가 있다는 뜻!
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        // a < b < c인 경우의 재귀 호출
        if (a < b && b < c) {
            // 다음 수식을 사용하여 결과 계산
            // w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            // 그 외의 경우에 대한 재귀 호출
            // 다음 수식을 사용하여 결과 계산
            // w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        // 계산된 값을 dp 배열에 저장하고 반환
        return dp[a][b][c];
    }
}