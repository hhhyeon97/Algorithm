// https://www.acmicpc.net/problem/6186
// Best Grass

// 14140KB	144ms

package baekjoon.week3.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6186_Best_Grass {

    static char[][] map;         // 필드 맵을 저장할 배열
    static boolean[][] isChecked; // 각 셀의 방문 여부를 기록할 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력에서 행과 열의 수를 읽어옴
        String[] split = br.readLine().split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);

        // 맵과 방문 여부 배열 초기화
        map = new char[row][col];
        isChecked = new boolean[row][col];

        // 맵의 각 행을 입력받아 배열에 저장
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 클럼프 -> 연속된 # 기호로 이루어진 덩어리

        int count = 0; // 클럼프의 개수를 세기 위한 변수

        // 필드의 각 셀을 검사
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // '#' 기호를 발견하고, 방문하지 않았다면 클럼프 탐색 시작
                if (map[i][j] == '#' && !isChecked[i][j]) {
                    dfs(i, j); // 깊이 우선 탐색 호출
                    count++; // 새로운 클럼프 발견
                }
            }
        }

        // 총 클럼프의 수를 출력
        System.out.println(count);
    }

    // 깊이 우선 탐색(DFS) 함수
    static void dfs(int i, int j) {

        // 현재 셀을 방문 처리
        isChecked[i][j] = true;

        // 하단 셀 (i + 1, j) 탐색
        if (i + 1 < map.length && !isChecked[i + 1][j] && map[i + 1][j] == '#') {
            dfs(i + 1, j);
        }

        // 우측 셀 (i, j + 1) 탐색
        if (j + 1 < map[0].length && !isChecked[i][j + 1] && map[i][j + 1] == '#') {
            dfs(i, j + 1);
        }
    }
}