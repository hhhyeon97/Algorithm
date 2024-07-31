// https://www.acmicpc.net/problem/9934
// 완전 이진 트리

// 14384KB	116ms
package baekjoon.week3.day13;
import java.util.*;
import java.io.*;


/*
노드 방문 순서가 담긴 배열을 반씩 쪼개가며 
중간값을 해당 깊이 list에 삽입한다.

dfs라 왼쪽 노드부터 쭉 탐색해간다.

마지막 왼쪽 노드에 도달할 경우 시작 인덱스와 마지막 인덱스의 번호가 [0, 0]
- > 중간 인덱스는 0이 되어 arr[0] 값이 해당 깊이 list에 담기게 된다.
*/

public class P9934 {
    static int K; // 트리의 깊이
    static int[] arr; // 노드 방문 순서
    static List<ArrayList<Integer>> list; // 깊이별 노드 저장 공간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리 깊이 K 입력받기
        K = Integer.parseInt(br.readLine());

        // 노드 순서 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 배열 크기 설정 (2^K - 1)
        arr = new int[(int) Math.pow(2, K) - 1]; // pow는 double을 반환함

        // 노드 순서 배열에 입력
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 깊이만큼 리스트 생성
        list = new ArrayList<>();
        for (int i = 0; i < K; i++)
            list.add(new ArrayList<>());

        // DFS로 트리 탐색
        dfs(0, arr.length - 1, 0);

        // 결과 출력
        for (int i = 0; i < K; i++) {
            for (int j : list.get(i))
                sb.append(j).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // DFS 함수: start와 end는 탐색 범위, depth는 현재 깊이
    static void dfs(int start, int end, int depth) {
        // 깊이가 K에 도달하면 종료(제일 하위 노드 도달)
        if (depth == K)
            return;

        // 중간 인덱스 계산
        int middle = (start + end) / 2;

        // 현재 깊이의 중간 노드 추가
        list.get(depth).add(arr[middle]);

        // 왼쪽 서브트리 탐색
        dfs(start, middle - 1, depth + 1);

        // 오른쪽 서브트리 탐색
        dfs(middle + 1, end, depth + 1);
    }
}
