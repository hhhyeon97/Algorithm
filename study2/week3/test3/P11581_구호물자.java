// https://www.acmicpc.net/problem/11581

package study2.week3.test3;

import java.io.*;
import java.util.*;

// 1. 플로이드 워셜 풀이

// 14640KB	128ms

public class P11581_구호물자 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 0번째 인덱스는 사용하지 않으므로 
        // 1부터 N 인덱스까지 사용하기 위해 N+1크기로 초기화
        boolean[][] graph = new boolean[N + 1][N + 1]; 

        // 그래프 초기화
        for (int i = 1; i < N; i++) {
            // 현재노드와 연결된 경로의 수
            int linkNum = Integer.parseInt(br.readLine());
            // 현재노드와 연결된 노드 입력
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < linkNum; j++) {
                // 현재노드와 연결된 노드
                int num = Integer.parseInt(st.nextToken());
                graph[i][num] = true;
            }
        }

        // 플로이드 워셜
        for (int i = 1; i < N; i++) { // 중간노드
            for (int j = 1; j < N; j++) { // 출발노드
                    // 출발노드에서 중간노드까지 가는 경로가 없으면 넘기기
                if (!graph[j][i]) { 
                    continue;
                }
                for (int k = 1; k < N; k++) { // 도착노드
                    if(graph[i][k]) { // 중간 ~ 도착 경로가 존재하면
                        graph[j][k] = true; // 출발 ~ 도착 경로 업데이트
                    }
                }
            }
        }
        // 1번 노드와 연결된 사이클 유무 검증
        for (int i = 1; i < N; i++) {
            if (graph[1][i] && graph[i][i]) {
                System.out.println("CYCLE");
                return;
            }
        }
        System.out.println("NO CYCLE");
    }
}

// 2. dfs 풀이

// 14476KB	144ms	

class Test {

    static int N; // 교차로의 수
    static int[] visited; // 방문 상태 배열
    static String result = "NO CYCLE"; // 결과 문자열
    
    // 인접 리스트
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 교차로 수 입력

        // 방문 상태 초기화
        // 0: 방문 안 함, 1: 탐색 완료, -1: 탐색 중
        visited = new int[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<Integer>());
        }

        // 각 교차로의 연결 상태 입력
        for (int i = 1; i < N; i++) {
            int M = Integer.parseInt(br.readLine()); // i번째 교차로의 연결된 교차로 수

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken())); // 연결된 교차로 추가
            }
        }

        // 사이클 탐색 시작
        findCycle(1);
        System.out.println(result); // 결과 출력
    }

    // DFS 활용 -> 사이클 탐색
    private static void findCycle(int from) {
        // 현재 정점이 탐색 중이면 사이클 발생
        if (visited[from] == -1) {
            result = "CYCLE";
            return;
        }

        // 현재 정점 방문 중으로 설정
        visited[from] = -1;

        // 현재 정점에서 갈 수 있는 모든 정점 탐색
        for (int v : graph.get(from)) {
            // 정점이 아직 탐색 완료되지 않았다면 재귀 호출
            if (visited[v] != 1) {
                findCycle(v);
            }
        }

        // 현재 정점 탐색 완료로 설정
        visited[from] = 1;
    }
}