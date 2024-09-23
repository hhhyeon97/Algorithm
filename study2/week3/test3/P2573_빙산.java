// https://www.acmicpc.net/problem/2573

// 190736KB	 624ms

package study2.week3.test3;

import java.io.*;
import java.util.*;

// 메인 클래스
public class P2573_빙산 {
/*
매년 빙산의 상태를 업데이트하고, 빙산이 두 덩어리 이상으로 분리되었는지 확인하는 문제

1. 입력 받기: 격자의 크기와 빙산의 높이 정보를 입력 받는다.
2. 시뮬레이션 루프: 매년 빙산의 덩어리 개수를 확인하고, 분리되면 연도 출력. 전부 녹으면 0 출력.
3. 빙산 덩어리 세기: BFS 사용 - > 덩어리 개수를 세고, 방문 여부를 체크
4. 빙산 녹이기: 인접한 바다의 수에 따라 빙산의 높이를 감소시킨다.
*/

        static int N, M; // 격자의 행과 열 크기
        static int[][] map, tempMap; // 현재 빙산 상태와 녹은 상태를 저장할 배열
        static boolean[][] visited; // 방문 여부 배열
        static int[] dx = {0, 1, 0, -1}; // 방향 배열 (동, 남, 서, 북)
        static int[] dy = {1, 0, -1, 0};
    
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            // 입력 받기
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            map = new int[N][M];
            tempMap = new int[N][M];
    
            // 빙산의 높이 정보 입력 받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
    
            int years = 0; // 경과된 시간(년)
    
            while (true) {
                // 1. 현재 빙산의 덩어리 개수 체크
                int count = countIcebergs();
                if (count > 1) {
                    System.out.println(years); // 빙산이 두 덩어리 이상으로 분리되었을 때
                    return;
                }
    
                // 2. 빙산의 녹는 과정 시뮬레이션
                meltIcebergs();
                
                // 3. 모든 빙산이 녹았으면 종료
                if (countIcebergs() == 0) {
                    System.out.println(0); // 모든 빙산이 녹았을 때
                    return;
                }
    
                years++; // 한 해가 지남
            }
        }
    
        // 현재 빙산의 덩어리 개수를 세는 함수
        private static int countIcebergs() {
            visited = new boolean[N][M]; // 방문 배열 초기화
            int count = 0; // 빙산 덩어리 수
    
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        // 새로운 덩어리 발견 시 BFS로 탐색
                        bfs(i, j);
                        count++;
                    }
                }
            }
    
            return count; // 덩어리 개수 반환
        }
    
        // BFS를 사용하여 덩어리 탐색
        private static void bfs(int x, int y) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, y});
            visited[x][y] = true;
    
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int cx = current[0];
                int cy = current[1];
    
                // 4방향 검사
                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
    
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    
        // 빙산이 녹는 과정 시뮬레이션
        private static void meltIcebergs() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        int melt = 0; // 현재 위치에서 녹을 양
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                                melt++; // 바다와 인접하면 녹을 양 증가
                            }
                        }
                        tempMap[i][j] = Math.max(map[i][j] - melt, 0); // 새로운 높이 계산
                    }
                }
            }
    
            // 갱신된 높이로 map 업데이트
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = tempMap[i][j];
                }
            }
        }
    }    