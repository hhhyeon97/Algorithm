// https://www.acmicpc.net/problem/1927
// 최소 힙

// 메모리 : 26340  KB	시간 : 300 ms

package baekjoon.week2.day9;

import java.io.*;
import java.util.PriorityQueue;

public class Test2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 우선순위 큐를 사용하여 최소 힙 구현
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 연산의 개수
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 힙이 비어있다면 0 출력, 아니면 가장 작은 값 출력 후 제거
                if (minHeap.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(minHeap.poll() + "\n");
                }
            } else {
                // 힙에 x 추가
                minHeap.add(x);
            }
        }
        bw.flush(); // 출력 버퍼 비우기
        bw.close();
        br.close();
    }
}