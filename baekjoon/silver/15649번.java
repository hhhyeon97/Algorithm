
// https://www.acmicpc.net/problem/15649
// N과 M (1)

// 61448KB	1684ms

// 백트래킹

/*
 * 해를 찾는 도중 해가 절대 될 수 없다고 판단되면, 
 * 되돌아가서 해를 다시 찾아가는 기법을 말한다. (되추적)
 * ㄴ> 다르게 표현하면
 * 어떤 노드의 유망성을 판단한 뒤, 
 * 해당 노드가 유망하지 않다면 부모 노드로 돌아가 다른 자식 노드를 찾는 알고리즘이다.
 (모든 경우의 수를 찾되, 그중에서 가능성 있는 경우의 수만 찾아보는 방법)
  ㄴ>
 * 알고리즘 기법 중 하나로 재귀적으로 문제를 해결하되 
 * 현재 재귀를 통해 확인 중인 상태가 제한 조건에 위배가 되는지 판단하고, 
 * 해당 상태가 위배되는 경우 해당 상태를 제외하고 다음 단계로 넘어간다.
 * 
 * KEY POINT는 더 이상 탐색할 필요가 없는 상태를 제외한다는 것인데, 
 * 이를 가지치기라고 한다.
 * 
 * 
 */

 /*
N개의 자연수 중에서 M개를 중복 없이 고른 수열을 모두 구해야 함.
중복을 허용하지 않음 → 한 번 사용한 숫자는 다시 사용할 수 없음.
사전 순으로 증가하는 순서로 출력해야 하므로, 수열을 작은 숫자부터 탐색해야 함.
*/ 

/*
 * 
 * 백트래킹을 활용한 풀이
 * 
1. DFS로 모든 경우의 수 탐색: DFS를 이용해서 깊이 탐색하면서 수열 생성
2. 백트래킹으로 가지치기: 한 번 선택한 숫자는 다시 선택하지 않도록 체크하고, M개의 숫자를 모두 선택하면 출력
3. 재귀적 구현: 수열의 길이가 M이 될 때까지 재귀를 돌리며 수를 추가하고, 조건에 맞으면 출력하고 돌아간다.

주요 단계
1. 방문 여부 체크: 배열 visited를 이용해 이미 선택된 숫자인지 확인
2. 재귀 호출: 길이가 M인 수열이 완성될 때까지 재귀 호출을 통해 수열을 만듦.
3. 조건에 맞는 수열 출력: 수열의 길이가 M이 되면 출력.
 * 
 */
import java.util.Scanner;

public class 15649번 {
    static int N, M;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N개의 자연수
        N = sc.nextInt(); 
        // M개의 수열 길이
        M = sc.nextInt(); 
        // 결과 수열 저장
        result = new int[M]; 
        // 방문 여부 체크
        visited = new boolean[N + 1]; 
        
        dfs(0); // 0번째 인덱스부터 시작
    }

    // DFS 탐색
    public static void dfs(int depth) {
        // M개의 숫자를 모두 선택했다면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        // 1부터 N까지 숫자 중 선택
        for (int i = 1; i <= N; i++) {
            // 이미 방문한 숫자는 제외
            if (!visited[i]) {
                visited[i] = true; // 방문 표시
                result[depth] = i; // 현재 선택된 숫자 저장
                dfs(depth + 1); // 다음 단계로
                visited[i] = false; // 백트래킹: 원상태로 복구
            }
        }
        sc.close();
    }
}