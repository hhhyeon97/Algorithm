// https://www.acmicpc.net/problem/16173


// https://tang25.tistory.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-16173%EB%B2%88-%EC%A0%90%ED%94%84%EC%99%95-%EC%A9%B0%EB%A6%ACSmall 참고

// 14208KB	128ms


// 인접 리스트를 사용한 예

package baekjoon.week3.day12;

import java.io.*;
import java.util.*;

public class P16173_점프왕_쩰리 {
  static int N; // 보드의 크기
  static int[][] board; // 보드 배열
  static boolean[][] visited; // 방문 여부 배열

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 보드 크기 입력
    N = Integer.parseInt(br.readLine());
    board = new int[N][N];
    visited = new boolean[N][N];
    
    // 보드 데이터 입력
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    // (0,0)에서 DFS 시작
    System.out.println(dfs(0, 0));
    br.close();
  }

  // DFS 탐색 함수
  static public String dfs(int x, int y) {
    int count = board[x][y]; // 현재 셀의 값
    visited[x][y] = true; // 현재 셀 방문 처리
    
    // 현재 셀의 값이 -1이면 목표에 도달한 것
    if (count == -1) {
      return "HaruHaru";
    }
    
    // 아래로 이동 (x + count, y)
    if (x + count < N && !visited[x + count][y] && !dfs(x + count, y).equals("Hing")) {
      return "HaruHaru";
    }
    
    // 오른쪽으로 이동 (x, y + count)
    if (y + count < N && !visited[x][y + count] && !dfs(x, y + count).equals("Hing")) {
      return "HaruHaru";
    }
    
    // 이동할 수 없는 경우
    return "Hing";
  }
}
