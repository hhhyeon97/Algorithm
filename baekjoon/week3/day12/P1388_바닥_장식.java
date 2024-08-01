// https://www.acmicpc.net/problem/1388
// 바닥 장식

// 14248KB	124ms

// https://somuchthings.tistory.com/190 참고

package baekjoon.week3.day12;

import java.io.*;

public class P1388_바닥_장식 {

    static int N, M; // 행과 열의 크기
    static char[][] ground; // 필드 맵
    static boolean[][] isVisited; // 방문 여부 배열
    static int ans; // 클럼프 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        ground = new char[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        // 필드 데이터 입력
        for (int i = 1; i <= N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                ground[i][j] = line[j - 1];
            }
        }

        // 모든 셀을 검사하여 DFS 수행
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                if (!isVisited[x][y])
                    dfs(x, y); // 방문하지 않은 셀에서 DFS 호출
            }
        }

        // 클럼프 수 출력
        System.out.println(ans);
    }

    public static void dfs(int x, int y) {
        isVisited[x][y] = true; // 현재 셀 방문 처리

        if (ground[x][y] == '-') { // 수평 클럼프 탐색
            if (y == M) { // 맵의 오른쪽 끝에 도달하면 클럼프 종료
                ans++;
                return;
            }

            int nextY = y + 1; // 다음 셀 탐색

            if (!isVisited[x][nextY] && ground[x][nextY] == '-')
                dfs(x, nextY); // 수평 클럼프의 연속 부분 탐색
            else {
                ans++; // 클럼프 종료
                return;
            }
        }

        if (ground[x][y] == '|') { // 수직 클럼프 탐색
            if (x == N) { // 맵의 아래쪽 끝에 도달하면 클럼프 종료
                ans++;
                return;
            }

            int nextX = x + 1; // 다음 셀 탐색

            if (ground[nextX][y] == '|' && !isVisited[nextX][y])
                dfs(nextX, y); // 수직 클럼프의 연속 부분 탐색
            else {
                ans++; // 클럼프 종료
                return;
            }
        }
    }
}