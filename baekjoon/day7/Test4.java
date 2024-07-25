// https://www.acmicpc.net/problem/10845
// 큐

// 메모리 :  20144 KB	시간 : 396 ms

package baekjoon.day7;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Test4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        // 명령어 수 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 명령 수행하기 !
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.offer(x); // 큐에 X를 추가
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println("-1"); // 큐가 비어있으면 -1 출력
                    } else {
                        System.out.println(queue.poll()); // 큐에서 값을 제거하고 출력
                    }
                    break;

                case "size":
                    System.out.println(queue.size()); // 큐의 크기 출력
                    break;

                case "empty":
                    System.out.println(queue.isEmpty() ? "1" : "0"); // 큐가 비어있으면 1, 아니면 0 출력
                    break;

                case "front":
                    System.out.println(queue.isEmpty() ? "-1" : queue.peek()); // 큐의 앞 값을 출력
                    break;

                case "back":
                    System.out.println(queue.isEmpty() ? "-1" : queue.toArray(new Integer[0])[queue.size() - 1]);
                    // 큐의 뒤 값을 출력
                    break;
            }
        }
    }
}