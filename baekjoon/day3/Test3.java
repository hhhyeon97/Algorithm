// https://www.acmicpc.net/problem/10994
// 별 찍기 - 19

// 메모리 : 31880 KB	시간 : 1248 ms

package baekjoon.day3;

import java.io.*;

public class Test3 {
    static char star[][]; // 2차원 배열 선언

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // N 값 입력 받음

        n = 4 * n - 3; // 출력될 패턴의 크기 계산 (4N - 3)

        star = new char[n][n]; // 패턴을 저장할 2차원 배열 생성

        // 2차원 배열을 공백으로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[i][j] = ' ';
            }
        }

        // 별 패턴 채우기
        Star_19(0, n);

        // 2차원 배열 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    // 재귀적으로 별 패턴을 그리는 함수
    public static void Star_19(int s, int len) {
        if (len <= s) // 종료 조건: 더 이상 그릴 수 있는 영역이 없을 때
            return;

        // 사각형의 외곽을 별로 채운다 !
        for (int i = s; i < len; i++) {
            star[s][i] = '*'; // 위쪽 가로줄
            star[len - 1][i] = '*'; // 아래쪽 가로줄
            star[i][s] = '*'; // 왼쪽 세로줄
            star[i][len - 1] = '*'; // 오른쪽 세로줄
        }

        // 내부의 작은 사각형을 그리기 위해 재귀 호출
        // 새로운 시작점은 s + 2, 새로운 길이는 len - 2가 된다.
        Star_19(s + 2, len - 2);
    }
}