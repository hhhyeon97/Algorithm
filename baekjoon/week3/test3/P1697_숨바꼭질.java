// https://www.acmicpc.net/problem/1697

// 18704KB	128ms

package baekjoon.week3.test3;

import java.io.*;
import java.util.*;

public class P1697_숨바꼭질 {
    // 조건 - 정수 
    static final int MAX = 100000;
    
    public static void main(String[] args) throws IOException{
        
        // 1. 입력 -> 첫째 줄에 수빈이, 동생 위치 
        
        // 2. 기능
        // 수빈이는 걷기 or 순간이동 가능
        // ex) 수빈이 위치 x일 때
        // 걷기 - > 1초 후에 x-1 or x+1로 이동
        // 순간이동 - > 1초 후에 2*x로 이동

        // 3. 출력 -> 수빈이가 동생을 찾는 가장 빠른 시간
        // -> 최단 경로를 찾는 문제
        // 그래프의 각 노드는 위치, 각 이동은 그래프의 간선으로 볼 수 있음
        // -> bfs 활용하기 (레벨별로 탐색을 진행)
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 수빈이 위치
        int k = Integer.parseInt(input[1]); // 동생 위치

        if (n>=k) {
            // 수빈이의 위치가 동생의 위치보다 클 때
            System.out.println(n-k);
            return;
        }

        br.close();
        
        // BFS 초기화
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { n, 0 }); // 위치와 시간
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            // 동생의 위치에 도달하면 결과 출력
            if (position == k) {
                System.out.println(time);
                return;
            }

            // 이동 방법 (걷기 - 뒤로 1보)
            if (position - 1 >= 0 && !visited[position - 1]) {
                queue.add(new int[] { position - 1, time + 1 });
                visited[position - 1] = true;
            }

            // 이동 방법 (걷기- 앞으로 1보)
            if (position + 1 <= MAX && !visited[position + 1]) {
                queue.add(new int[] { position + 1, time + 1 });
                visited[position + 1] = true;
            }
            // 순간이동 방법
            if (2 * position <= MAX && !visited[2 * position]) {
                queue.add(new int[] { 2 * position, time + 1 });
                visited[2 * position] = true;
            }
        }
        
    }
}


/*
BFS 초기화:

BFS 큐에 수빈이의 시작 위치와 시간을 0으로 !
위치를 방문했는지를 체크하는 배열 초기화
visited 배열을 사용하여 이미 방문한 위치를 체크
Queue를 사용하여 현재 위치와 시간을 저장하고, BFS를 시작한다.

경계 조건:
이동 방법과 범위 체크를 통해 그래프의 모든 가능한 노드를 탐색

BFS 탐색:
큐에서 현재 위치와 경과 시간을 꺼낸다.
이동 가능한 다음 위치를 계산하여 큐에 추가한다.(현재 위치에서 가능한 모든 이동을 큐에 추가)
위치가 동생의 위치와 일치하면 탐색을 종료하고 시간을 출력한다.
*/