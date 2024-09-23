// https://www.acmicpc.net/problem/3098

// 14532KB	136ms

package study2.week3.day13;

import java.io.*;
import java.util.*;

public class P3098_소셜네트워크 {
    static final int MAX_N = 50; // 최대 사람 수
    static boolean[][] friends = new boolean[MAX_N][MAX_N]; // 친구 관계를 저장하는 인접 행렬
    static boolean[][] newFriends = new boolean[MAX_N][MAX_N]; // 매일 새로 생긴 친구 관계를 저장하는 인접 행렬
    static int N; // 사람 수
    static int M; // 초기 친구 관계 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 수 입력 받기
        N = Integer.parseInt(st.nextToken());
        // 친구 관계 수 입력 받기
        M = Integer.parseInt(st.nextToken());

        // 초기 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1; // 사람 A (0-based index)
            int B = Integer.parseInt(st.nextToken()) - 1; // 사람 B (0-based index)
            friends[A][B] = true; // A와 B가 친구임을 표시
            friends[B][A] = true; // B와 A가 친구임을 표시 (대칭)
        }

        int days = 0; // 친구 관계가 모두 확장되는 데 걸린 일수
        List<Integer> newFriendsCount = new ArrayList<>(); // 각 날마다 새로 생긴 친구 관계 수를 저장하는 리스트

        // 모든 사람이 친구가 될 때까지 반복
        while (!allFriends()) {
            days++; // 하루가 지남

            int count = 0; // 오늘 새로 생긴 친구 관계 수

            // 새로운 친구 관계 생성
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j && friends[i][j]) { // i와 j가 친구일 때
                        for (int k = 0; k < N; k++) {
                            if (k != i && k != j && friends[j][k] && !friends[i][k]) {
                                // k가 i의 친구가 아니고 j의 친구일 때, i와 k가 새 친구가 됨
                                if (!newFriends[i][k]) { // 새로 생긴 친구 관계인지 확인
                                    newFriends[i][k] = true; // 새 친구 관계 표시
                                    newFriends[k][i] = true; // 대칭 관계 표시
                                    count++; // 새 친구 관계 수 증가
                                }
                            }
                        }
                    }
                }
            }

            // 친구 관계 업데이트
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (newFriends[i][j]) { // 새 친구 관계가 있다면
                        friends[i][j] = true; // 친구 관계 업데이트
                        friends[j][i] = true; // 대칭 관계 업데이트
                    }
                }
            }

            // 새로운 친구 관계 수 기록
            newFriendsCount.add(count);
            resetNewFriends(); // 다음 날을 위해 새로운 친구 관계 초기화
        }

        // 결과 출력
        System.out.println(days); // 총 걸린 일수 출력
        for (int count : newFriendsCount) {
            System.out.println(count); // 각 날마다 새로 생긴 친구 관계 수 출력
        }
    }

    // 모든 사람이 친구가 되었는지 확인
    static boolean allFriends() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && !friends[i][j]) { // 모든 사람 쌍이 친구인지 확인
                    return false; // 친구가 아닌 쌍이 있으면 false 반환
                }
            }
        }
        return true; // 모든 사람이 친구가 되면 true 반환
    }

    // 새로운 친구 관계를 초기화
    static void resetNewFriends() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(newFriends[i], false); // 새 친구 관계 배열 초기화
        }
    }
}