// https://www.acmicpc.net/problem/1939

// 65120KB	596ms

package study2.week3.test3;

import java.io.*;
import java.util.*;

public class P1939_중량제한 {
    static int N, M; // 섬의 수, 다리의 수
    static List<int[]>[] graph; // 그래프: 인접 리스트 (섬 번호와 중량 제한)
    static int start, end; // 공장이 위치한 섬 번호
    
    public static void main(String[] args) throws IOException {
        /*
        그래프 초기화: 각 섬을 리스트로 초기화 -> 다리 정보를 그래프에 추가
        이진 탐색: 최대 중량 제한을 찾기 위해 이진 탐색 수행
        BFS 탐색: 주어진 중량 제한으로 두 공장 사이에 경로가 있는지 확인
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 다리 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 양방향 다리 추가
            graph[A].add(new int[]{B, C});
            graph[B].add(new int[]{A, C});
        }

        // 공장 위치 입력
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 최대 중량 제한 찾기
        System.out.println(findMaximumWeight());
    }

    // 이진 탐색으로 최대 중량 제한 찾기
    private static int findMaximumWeight() {
        int left = 1;
        int right = 1_000_000_000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 현재 중량 제한으로 경로 존재 여부 확인
            if (canReach(mid)) {
                result = mid; // 경로가 있으면 결과 업데이트
                left = mid + 1; // 더 큰 중량 제한으로 탐색
            } else {
                right = mid - 1; // 더 작은 중량 제한으로 탐색
            }
        }

        return result;
    }

    // BFS 사용 - > 특정 중량 제한으로 두 공장 사이 경로 확인
    private static boolean canReach(int minWeight) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return true; // 도착하면 true 반환
            }

            // 현재 정점에서 갈 수 있는 모든 이웃 정점 탐색
            for (int[] neighbor : graph[current]) {
                int next = neighbor[0];
                int weight = neighbor[1];

                if (!visited[next] && weight >= minWeight) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return false; // 도착하지 못하면 false 반환
    }
}