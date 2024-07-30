// https://www.acmicpc.net/problem/1863
// 스카이라인 쉬운거

// 메모리 - 19704 KB	시간 - 220 ms

package baekjoon.test2;

import java.io.*;
import java.util.*;

public class P1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x 좌표 (현재 문제에서는 사용하지 않음)
            int y = Integer.parseInt(st.nextToken()); // 높이

            // 현재 높이 y가 스택의 마지막 높이보다 낮으면
            // 더 이상 그 높이를 가진 건물은 없으므로
            // 스택에서 높이들을 pop 하면서 건물 개수를 증가시킴
            while (!stack.isEmpty() && stack.peek() > y) {
                answer++;
                stack.pop();
            }

            // 현재 높이 y가 스택의 마지막 높이와 같다면
            // 이미 같은 높이의 건물이 있으므로 같은 건물로 처리됨
            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }

            // 현재 높이 y가 스택의 마지막 높이보다 크면
            // 새로운 건물이 생긴 것이므로 스택에 push
            stack.push(y);
        }

        // 스택이 비지 않았다면 -> 남아있는 건물들이 있다는 의미
        // 스택에 남은 높이들 각각이 별도의 건물을 나타냄
        // 남은 건물 개수만큼 증가시킴
        while (!stack.isEmpty()) {
            if (stack.peek() > 0) {
                answer++;
            }
            stack.pop();
        }

        // 최소 건물 개수를 출력
        System.out.println(answer);
    }
}

/*
스택에 높이 저장:

스택에 현재까지의 최대 높이를 저장하여 스카이라인을 표현.

높이 감소 시 처리:

현재 높이 y가 이전 높이보다 낮으면, 
이전 높이들(건물들)을 제거하고, 새로운 건물의 수를 증가시킴.

높이 같을 때 무시:

현재 높이 y가 스택의 마지막 높이와 같으면, 이미 같은 건물이 있으므로 처리하지 않음.

높이 증가 시 처리:

현재 높이 y가 스택의 마지막 높이보다 크면, 새로운 건물의 높이를 스택에 추가함.

남은 건물 처리:

모든 입력을 처리한 후에도 스택에 남아있는 건물들을 카운트함.
*/