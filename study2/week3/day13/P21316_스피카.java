// https://www.acmicpc.net/problem/21316

// 14312KB	116ms
package study2.week3.day13;

import java.io.*;
import java.util.*;

public class P21316_스피카 {

    // 스피카 특징
    // 1. 간선 3개와 연결 되어 있다. <- (3,4,7,9 해당)
    // 2. 연결된 정점들의 간선의 총합이 6이다. <- 정점들 중에 스피카만 해당하고 있음 ! 
    // - > 스피카 (7번)
    // - > 스피카와 연결된 노드 (3,6,8)
    // - > 3번 노드 (2,4,7->3개), 6번 노드 (7->1개), 8번 노드(7,9->2개)
    // -> 3+1+2 = 6
    // 결론 : 스피카는 3개의 간선으로 연결된 정점이며 연결된 정점들의 총 간선 수의 합이 6인 정점이다.
    // 해당하는 정점을 찾아서 출력해 !! 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         // 인접 리스트 생성: 각 정점의 인접 정점 목록을 저장
         List<List<Integer>> list = new ArrayList<>();
        
         // 각 정점의 차수(연결된 간선의 개수)를 저장할 배열
         int[] arr = new int[13];
 
         // 13개의 빈 ArrayList를 인접 리스트에 추가하여 초기화
         for (int i = 0; i < 13; i++) {
             list.add(new ArrayList<>());
         }
 
         // 입력으로 주어진 정점 간의 연결 정보를 읽어들여 인접 리스트와 차수 배열을 업데이트
         for (int i = 1; i < 13; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
 
             // 각 정점의 차수(연결된 간선 수) 증가
             arr[a]++;
             arr[b]++;
 
             // 인접 리스트에 연결된 정점 추가
             list.get(a).add(b);
             list.get(b).add(a);
         }
 
         // 차수가 3인 정점을 탐색
         for (int i = 1; i < 13; i++) {
             // 차수가 3이 아닌 정점은 무시
             if (arr[i] != 3) {
                 continue;
             }
 
             // 차수가 3인 정점을 찾았을 경우
             int sum = 0;
             // 해당 정점과 인접한 모든 정점의 차수를 합산
             for (int j = 0; j < 3; j++) {
                 sum += arr[list.get(i).get(j)];
             }
 
             // 인접 정점의 차수 합이 6이면 해당 정점을 출력하고 탐색 종료
             if (sum == 6) {
                 System.out.println(i);
                 break;
             }
         }
    }
}
