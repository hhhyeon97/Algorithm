// https://www.acmicpc.net/problem/1926
// 49548	400

package baekjoon.week3.day14;

import java.io.*;
import java.util.*;

public class P1926_그림 {
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static int n, m;
    static int[][] canvas;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        canvas = new int[n][m];
        visited = new boolean[n][m];

        // 도화지 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCount = 0;
        int maxArea = 0;

        // 도화지의 모든 셀을 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 1 && !visited[i][j]) {
                    // 새로운 그림 발견, DFS로 그림의 넓이 계산
                    int area = dfs(i, j);
                    pictureCount++;
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(pictureCount);
        System.out.println(maxArea);
    }

    // DFS 탐색
    private static int dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        int area = 0;

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int curX = pos[0];
            int curY = pos[1];
            area++;

            for (int i = 0; i < 4; i++) { // 상하좌우
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if (isValid(newX, newY) && canvas[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    stack.push(new int[]{newX, newY});
                }
            }
        }

        return area;
    }

    // 유효한 좌표인지 확인하는 메서드
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}