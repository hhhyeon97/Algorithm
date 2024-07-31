// https://www.acmicpc.net/problem/10994
// 별 찍기 - 19

// 메모리 : 31880 KB	시간 : 1248 ms

package baekjoon.week1.day3;

import java.io.*;

public class Test3 {
    static char star[][]; // 2차원 배열 선언

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // N 값 입력 받음

        n = 4 * n - 3; // 출력될 패턴의 크기 계산 (4N - 3) - > 패턴의 외곽선과 내부의 빈 공간을 포함한 크기

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

/*
패턴 그리기:

Star_19(0, n) 함수를 호출하여 재귀적으로 별 패턴을 채운다.
Star_19 함수는 시작점 s와 현재 길이 len을 받아 외곽선부터 내부까지 별을 그린다.
외곽선을 별로 채운 후, 시작점과 길이를 조정하여 내부의 작은 사각형을 재귀적으로 그린다.

재귀 함수 Star_19:

len이 s보다 작거나 같아지면 더 이상 그릴 필요가 없으므로 재귀를 종료한다.
외곽선을 따라 별을 채웁니다. 위쪽, 아래쪽 가로줄과 왼쪽, 오른쪽 세로줄을 별로 채운다.
시작점을 2 증가시키고, 길이를 2 감소시켜 내부 사각형을 그리도록 재귀 호출을 한다.
*/