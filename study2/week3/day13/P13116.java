// https://www.acmicpc.net/problem/13116
// 30번

// 아직 이해 못함...어렵네 ?! 악 !

// 30956KB	416ms

package study2.week3.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13116 {

    // 트리의 깊이와 부모 배열 선언
    static int[] depth = new int[1024];
    static int[][] parent = new int[1024][11];

    // DFS 사용 -> 트리의 깊이와 부모 정보 초기화
    static void dfs(int v, int d) {
        depth[v] = d;
        parent[v][0] = v / 2; // 부모 정보 설정

        int next = v * 2; // 왼쪽 자식

        if (next >= 1024) // 노드 인덱스가 1023을 초과하면 리턴
            return;

        // 왼쪽 자식과 오른쪽 자식에 대해 재귀 호출
        dfs(next, d + 1);
        dfs(next + 1, d + 1);
    }

    // 트리의 초기화 작업
    static void init() {
        dfs(1, 1); // 루트 노드 1부터 DFS 시작
        for (int j = 1; j < 11; j++) { // 2^j 조상 정보를 계산
            for (int i = 1; i <= 1023; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }

    // 두 노드의 최소 공통 조상을 찾는 함수
    static int lca(int x, int y) {
        // y의 깊이를 x의 깊이에 맞춰 조정
        if (depth[x] > depth[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        // y를 x와 같은 깊이로 맞추기
        for (int i = 10; i >= 0; i--) {
            if (depth[y] - depth[x] >= (1 << i)) {
                y = parent[y][i];
            }
        }

        // x와 y가 같으면 그 노드가 공통 조상
        if (x == y)
            return x;

        // 공통 조상이 발견될 때까지 올라가기
        for (int i = 10; i >= 0; i--) {
            if (parent[x][i] != parent[y][i]) {
                x = parent[x][i];
                y = parent[y][i];
            }
        }

        // 공통 조상의 부모 반환
        return parent[x][0];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 결과를 저장할 StringBuffer
        StringBuffer sb = new StringBuffer(); 

        // 트리 초기화
        init();

        // 입력 처리 및 결과 출력
        st = new StringTokenizer(br.readLine());
        // 테스트 케이스 수
        int tc = Integer.parseInt(st.nextToken()); 

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // LCA를 찾아서 결과에 추가
            sb.append(lca(u, v) * 10 + "\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}