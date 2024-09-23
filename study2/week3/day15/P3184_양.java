// https://www.acmicpc.net/problem/3184

// 16724KB	152ms

package study2.week3.day15;

import java.util.*;
import java.io.*;

public class P3184_양 {
    // n: 행의 수, m: 열의 수
    // map: 격자 배열
    // visited: 각 셀의 방문 여부를 기록하는 배열
    // dx, dy: 4방향 탐색을 위한 이동값
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static final int[] dx = { 0, 1, 0, -1 }; // 이동 방향 (오른쪽, 아래, 왼쪽, 위)
    static final int[] dy = { 1, 0, -1, 0 };
    static int sheep, wolf, totalS, totalW; // 양 개수, 늑대 개수, 총 양 개수, 총 늑대 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 행과 열의 수를 읽어옴
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행의 수
        m = Integer.parseInt(st.nextToken()); // 열의 수

        map = new char[n][m]; // 격자 배열 초기화
        visited = new boolean[n][m]; // 방문 배열 초기화

        // 격자 배열을 입력받음
        for (int i = 0; i < n; i++) {
            String str = br.readLine(); // 한 줄의 문자열을 읽음
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j); // 문자열의 각 문자를 격자 배열에 저장
            }
        }

        totalS = 0; // 총 양 개수 초기화
        totalW = 0; // 총 늑대 개수 초기화

        // 격자 배열을 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치가 양('o') 또는 늑대('v')이며 방문하지 않은 경우
                if ((map[i][j] == 'o' || map[i][j] == 'v') && !visited[i][j]) {
                    sheep = 0; // 양 개수 초기화
                    wolf = 0; // 늑대 개수 초기화

                    // DFS를 호출하여 울타리 내의 양과 늑대를 세어봄
                    dfs(i, j);

                    // 울타리 내의 양과 늑대 개수를 비교하여 총합에 추가
                    if (sheep > wolf)
                        totalS += sheep; // 양이 많으면 총 양 개수에 추가
                    else
                        totalW += wolf; // 늑대가 많거나 같으면 총 늑대 개수에 추가
                }
            }
        }
        // 결과 출력 (총 양 개수, 총 늑대 개수)
        System.out.println(totalS + " " + totalW);
    }

    // 깊이 우선 탐색(DFS) 함수
    static void dfs(int x, int y) {
        visited[x][y] = true; // 현재 위치를 방문 처리

        // 현재 위치의 셀에 양('o')이나 늑대('v')가 있는지 확인
        if (map[x][y] == 'v')
            wolf++; // 늑대일 경우 늑대 개수 증가
        if (map[x][y] == 'o')
            sheep++; // 양일 경우 양 개수 증가

        // 4방향(상하좌우)으로 탐색
        for (int i = 0; i < 4; i++) {
            // 새로운 x,y 좌표
            int nx = x + dx[i]; 
            int ny = y + dy[i]; 

            // 새로운 좌표가 격자 범위 내에 있는지 + 울타리('#')가 아닌지 + 방문하지 않은 위치인지 확인
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '#' || visited[nx][ny]) {
                continue; // 조건에 맞지 않으면 탐색 건너 뛰기 
            }

            // 조건을 만족하면 재귀적으로 DFS 호출
            dfs(nx, ny);
        }
    }
}