// https://www.acmicpc.net/problem/1743

// 17456KB	144ms

package baekjoon.week3.day15;

import java.io.*;
/*
주어진 격자(grid)에서 음식물 쓰레기가 위치한 곳을 탐색하여
가장 큰 음식물 덩어리의 크기를 찾는 문제
*/
public class P1743_음식물_피하기 {
      // 이동 방향: 아래, 위, 오른쪽, 왼쪽
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 격자 배열과 방문 여부를 기록할 배열
    static int[][] arr;
    static boolean[][] visited;

    // 최대 음식물 덩어리의 크기
    static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 격자의 크기와 음식물 쓰레기 개수 읽기
        String[] lineBr = br.readLine().split(" ");
        int N = Integer.parseInt(lineBr[0]); // 격자의 세로 크기
        int M = Integer.parseInt(lineBr[1]); // 격자의 가로 크기
        int K = Integer.parseInt(lineBr[2]); // 음식물 쓰레기 개수

        // 격자 배열과 방문 배열 초기화
        arr = new int[N][M];
        visited = new boolean[N][M];
        maxCount = 0; // 최대 음식물 덩어리 크기 초기화

        // 격자 배열을 0으로 초기화
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 0;
            }
        }

        // 음식물 쓰레기 위치를 1로 표시
        for (int i = 0; i < K; i++) {
            lineBr = br.readLine().split(" ");
            int x = Integer.parseInt(lineBr[0]);
            int y = Integer.parseInt(lineBr[1]);
            arr[x - 1][y - 1] = 1; // 입력은 1부터 시작하므로, 0-based index로 변환
        }

        // 모든 좌표에서 DFS 탐색 시작
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                // 음식물 쓰레기가 있고 아직 방문하지 않은 경우
                if (arr[i][j] == 1 && !visited[i][j]) {
                    // DFS로 음식물 덩어리의 크기를 계산
                    int widthDraw = dfs(i, j);
                    // 최대 크기 갱신
                    if (maxCount < widthDraw) {
                        maxCount = widthDraw;
                    }
                }
            }
        }

        // 최대 음식물 덩어리 크기 출력
        System.out.println(maxCount);
    }

    // DFS 탐색 함수
    static int dfs(int x, int y) {
        visited[x][y] = true; // 현재 좌표 방문 처리
        int area = 1; // 현재 칸의 크기 (1로 카운팅)

        // 4방향으로 이동하며 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 이동한 좌표가 격자 범위 내에 있는지 확인
            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                // 이동한 좌표가 음식물 쓰레기이고, 방문하지 않은 경우
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    // 재귀적으로 DFS 호출하여 덩어리 크기 누적
                    area += dfs(nx, ny);
                }
            }
        }
        return area; // 현재 음식물 덩어리의 총 크기 반환
    }
}
