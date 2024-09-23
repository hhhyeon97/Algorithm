// https://www.acmicpc.net/problem/21938

// 143108KB	672ms

package study2.week3.day15;


import java.io.*;

public class P21938_영상처리 {
    static int N, M; // 세로 N, 가로 M
    static boolean[][] visited; // 방문 여부 배열
    static int count = 0; // 물체 개수
    static int[][] map; // 픽셀 화면
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        // 1. 입력
        // 첫번째 줄 -> N과 M
        // 다음줄부터 r,g,b를 입력받아 해당 값들의 평균을 map에 넣어주기
        // 마지막줄에서 경계값 T를 입력받아 map을 재탐색하며 T 이상의 값은 255 아니면 0으로 갱신
        // 2. 기능
        // dfs 탐색을 활용하여 map 탐색
     
        // 3. 출력 - > count 출력하기
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M]; // 배열 초기화 
        visited = new boolean[N][M]; // 방문 여부 배열 초기화

        // 픽셀의 색상 값 입력 및 평균 계산
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int R = Integer.parseInt(line[j * 3]);
                int G = Integer.parseInt(line[j * 3 + 1]);
                int B = Integer.parseInt(line[j * 3 + 2]);
                map[i][j] = (R + G + B) / 3;
            }
        }

        
        int T = Integer.parseInt(br.readLine()); // 경계값
        
        // 경계값에 따라 픽셀 값 변환
        // T 이상일 경우 255 아니면 0으로 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = (map[i][j] >= T) ? 255 : 0;
            }
        }  // for문 끝

        // 물체 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 255이거나 방문하지 않은 곳(물체가 있다면)이라면 
                if (map[i][j] == 255 && !visited[i][j]){ 
                    // 탐색
                    dfs(i,j); 
                    // 탐색이 끝나면 count 증가
                    count++; 
                }
            }
        } // for문 끝
        
        // 물체 개수 출력
        System.out.println(count);  
        br.close();
    }

    static void dfs(int x, int y) {
         // 현재 위치 방문상태로 변경하기
        visited[x][y] = true;

        // 네 방향에 대해 탐색
        for (int i = 0; i < 4; i++) { 
            int nx = x + dx[i]; // 이동할 새로운 x 좌표
            int ny = y + dy[i]; // 이동할 새로운 y 좌표

            // 새로운 좌표가 화면 범위 내에 있는지 확인
            // (nx, ny) 좌표가 화면 범위를 벗어나지 않고,
            // 해당 좌표의 값이 255(물체의 일부)이며,
            // 아직 방문하지 않은 경우에만 DFS 재귀 호출
            if (nx >= 0 && ny >= 0 && nx < N && ny < M 
                && map[nx][ny] == 255 && !visited[nx][ny]) {
                dfs(nx, ny); // 유효한 좌표에서 DFS 호출
            }
            
        }// for문 끝
    }
}