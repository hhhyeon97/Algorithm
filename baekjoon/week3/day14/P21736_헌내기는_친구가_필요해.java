// https://www.acmicpc.net/problem/21736

/*
그래프 전체를 탐색하여 사람의 수를 센다. -> BFS, DFS 둘 다 가능
뭐가 더 효율적인진...잘 모르겠다 -> DFS로 접근해볼게 ?!
조건에 따라 처리 필요
1. 벽이 있는 경우
2. 좌표 벗어나지 않게 한다 (캠퍼스 벗어나면 안 돼!)
3. 아무도 만나지 못한 경우
4. 이미 방문한 경우
*/
import java.io.*;
import java.util.*;

public class P21736_헌내기는_친구가_필요해 {
        static int N, M; // 캠퍼스의 행/열 크기
        static char[][] campus; // 캠퍼스 맵
        static boolean[][] visited; // 방문 여부
        // 상하좌우 이동에 대한 행/열
        static int[] dx = { -1, 1, 0, 0 };
        static int[] dy = { 0, 0, -1, 1 };

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                // 캠퍼스의 크기 입력 받기
                String[] dimensions = br.readLine().split(" ");
                N = Integer.parseInt(dimensions[0]);
                M = Integer.parseInt(dimensions[1]);

                campus = new char[N][M]; // 캠퍼스 맵 배열 초기화
                int startX = -1, startY = -1; // 도연이의 위치 저장할 변수

                // 캠퍼스 맵을 입력 받고 도연이의 위치를 찾기
                for (int i = 0; i < N; i++) {
                        String line = br.readLine(); // 각 행을 입력 받음
                        for (int j = 0; j < M; j++) {
                                campus[i][j] = line.charAt(j); // 캠퍼스 맵 배열에 저장
                                if (campus[i][j] == 'I') { // 도연이('I')의 위치 찾기
                                        startX = i;
                                        startY = j;
                                }
                        }
                }

                visited = new boolean[N][M]; // 방문 배열 초기화

                // DFS 탐색 -> 도연이가 만날 수 있는 사람의 수 계산
                int peopleCount = dfs(startX, startY);

                // 만난 사람의 수 출력
                if (peopleCount == 0) {
                        System.out.println("TT");
                } else {
                        System.out.println(peopleCount);
                }
        }

        private static int dfs(int x, int y) {
                Stack<int[]> stack = new Stack<>(); // 방문할 위치를 저장할 스택
                stack.push(new int[] { x, y }); // 도연이 시작 위치를 스택에 추가
                visited[x][y] = true; // 도연이 위치를 방문 처리

                int peopleCount = 0; // 만난 사람의 수 카운트할 변수

                while (!stack.isEmpty()) { // 스택이 비어 있을 때까지 반복
                        int[] pos = stack.pop(); // 스택에서 위치를 꺼냄
                        int curX = pos[0];
                        int curY = pos[1];

                        // 현재 위치가 사람('P')인 경우 카운트
                        if (campus[curX][curY] == 'P') {
                                peopleCount++;
                        }

                        // 상하좌우 이동
                        for (int i = 0; i < 4; i++) {
                                int newX = curX + dx[i]; // 새로운 행 위치
                                int newY = curY + dy[i]; // 새로운 열 위치

                                // 새로운 위치가 유효하면서 방문하지 않았으며
                                // 벽이 아닌 경우 처리
                                if (isValid(newX, newY) && !visited[newX][newY] && campus[newX][newY] != 'X') {
                                        stack.push(new int[] { newX, newY }); // 스택에 추가
                                        visited[newX][newY] = true; // 방문 처리
                                }
                        }
                }
                return peopleCount; // 만난 사람 수 반환
        }

        // 새로운 위치가 캠퍼스의 범위 내에 있는지 확인할 메서드
        private static boolean isValid(int x, int y) {
                return x >= 0 && x < N && y >= 0 && y < M;
        }
}

/*
주석 설명

1. 변수 선언:

N, M: 캠퍼스의 행과 열의 크기
campus: 캠퍼스의 맵을 저장하는 2차원 배열
visited: 방문 여부를 저장하는 2차원 배열
dx, dy: 상하좌우 이동을 위한 배열 (행과 열의 변화량)

2. 입력 처리:

BufferedReader를 사용하여 입력 받음
첫 줄에서 캠퍼스의 크기를 읽어 N과 M을 설정
나머지 줄에서 캠퍼스의 맵을 읽어 campus 배열에 저장하고, 도연이('I')의 위치 찾음

3. DFS 탐색:

Stack을 사용하여 DFS 수행
스택에서 현재 위치를 꺼내서 상하좌우로 이동할 수 있는 위치를 탐색
새로운 위치가 유효하고 방문하지 않았으며 벽이 아닌 경우 스택에 추가
사람('P')을 만난 경우 카운트

4. 결과 출력:

만난 사람의 수 출력 -> 만난 사람이 없으면 "TT" 출력
*/