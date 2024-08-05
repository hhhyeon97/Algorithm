// https://www.acmicpc.net/problem/13565

// 53060KB	1060ms
package baekjoon.week3.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P13565_침투 {
    // 행/열의 수
    static int rows, cols;
    // 2D 격자 배열
    static int[][] grid;
    // 방문 여부를 체크하는 배열
    static boolean[][] visited;
    // 상하좌우 이동 방향
    static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    // 전류가 안쪽까지 침투했는지 여부
    static boolean currentReaches = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 격자의 크기 입력
        String[] input = br.readLine().split(" ");
        rows = Integer.parseInt(input[0]);
        cols = Integer.parseInt(input[1]);

        // 격자 배열 초기화
        grid = new int[rows][cols];
        visited = new boolean[rows][cols];

        // 격자 배열에 격자 정보 저장
        for (int i = 0; i < rows; i++) {
            String line = br.readLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }
        // 첫 번째 행에서 전류가 통하는 칸을 시작점으로 DFS 수행
        // 첫 번째 행의 흰색 격자에서 DFS를 시작하는 것 ! 
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 0) {
                dfs(0, i);
            }
        }

        // 결과 출력
        System.out.println(currentReaches ? "YES" : "NO");
        br.close();
    }

    // DFS를 통해 전류가 흰색 격자로 이동
    // DFS를 통해 상하좌우로 이동하며 전류가 마지막 행에 도달하는지 확인하는 메서드 
    public static void dfs(int row, int col) {
        // 현재 위치 방문 처리
        visited[row][col] = true;
        // 마지막 행에 도달했으면 전류가 침투한 것
        if (row == rows - 1) {
            currentReaches = true;
            return;
        }

        // 상하좌우로 이동
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // 새로운 위치가 유효하고, 방문하지 않았으며, 흰색(전류 통하는) 경우
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                dfs(newRow, newCol);
            }
        }
    }
}