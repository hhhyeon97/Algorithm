// https://www.acmicpc.net/problem/4963

// 참고
// https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-4963%EB%B2%88-%EC%84%AC%EC%9D%98-%EA%B0%9C%EC%88%98-with-%EC%9E%90%EB%B0%94


// 15344KB	124ms
package baekjoon.week3.day14;


import java.io.*;
import java.util.*;

public class P4963_섬의_개수 {
    static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 }; // 상하좌우, 대각선
    static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 }; // 상하좌우, 대각선

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] dimensions = br.readLine().split(" ");
            int w = Integer.parseInt(dimensions[0]);
            int h = Integer.parseInt(dimensions[1]);

            if (w == 0 && h == 0)
                break; // 입력 종료 조건

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            // 지도 입력 받기
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j * 2) - '0'; // 각 문자를 정수로 변환
                }
            }

            // 섬의 개수 계산하기
            int islandCount = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(map, visited, i, j, h, w);
                        islandCount++;
                    }
                }
            }

            // 결과 저장
            sb.append(islandCount).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }

    // DFS 탐색
    private static void dfs(int[][] map, boolean[][] visited, int x, int y, int h, int w) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { x, y });
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int curX = pos[0];
            int curY = pos[1];

            for (int i = 0; i < 8; i++) { // 상하좌우 + 대각선
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if (isValid(newX, newY, h, w) && map[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    stack.push(new int[] { newX, newY });
                }
            }
        }
    }

    // 유효한 좌표인지 확인할 메서드
    private static boolean isValid(int x, int y, int h, int w) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }
}
