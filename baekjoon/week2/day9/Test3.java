// https://www.acmicpc.net/problem/14235
// 크리스마스 선물

// 메모리 : 40520  KB	시간 : 432 ms

package baekjoon.week2.day9;

import java.io.*;
import java.util.PriorityQueue;

public class Test3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 최대 힙 구현을 위해 PriorityQueue를 사용
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // 연산의 개수
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);

            if (a == 0) {
                // 최대 힙에서 가장 큰 값을 출력하고 제거
                if (maxHeap.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(maxHeap.poll() + "\n");
                }
            } else {
                // 선물 가치를 최대 힙에 추가
                for (int j = 1; j <= a; j++) {
                    maxHeap.add(Integer.parseInt(input[j]));
                }
            }
        }

        bw.flush(); // 출력 버퍼 비우기
        bw.close();
        br.close();
    }
}

/*
ex ) 

입력 :

5
0
2 3 2
0
0
0

출력:

-1
3
2
-1

*/

/*
설명 :

첫 번째 줄 (0):

0이 입력되면, 현재 힙에서 가장 큰 값을 출력해야 한다.
하지만 이때는 힙이 비어있으므로 출력은 -1이 됨

두 번째 줄 (2 3 2):

2가 첫 번째 숫자이고, 그 뒤에 3과 2가 있음
즉, 이 줄에서 2개의 선물(3과 2)을 힙에 추가한다.
PriorityQueue (최대 힙)를 사용하여, 3과 2를 힙에 추가하는데
현재 힙의 상태: [3, 2] (최대 힙이므로 3이 가장 위에 있음.)


세 번째 줄 (0):

0이 입력되면, 현재 힙에서 가장 큰 값을 출력하고 제거
현재 힙에는 3과 2가 있으므로, 3이 가장 큰 값이니까 3을 출력하고 제거
현재 힙의 상태: [2] (이제 2만 남아 있다.)

네 번째 줄 (0):

0이 입력되면, 현재 힙에서 가장 큰 값을 출력하고 제거
현재 힙에는 2만 남아 있으므로, 2가 가장 큰 값 - > 2를 출력하고 제거
현재 힙의 상태: [] (이제 힙이 비어 있다.)

다섯 번째 줄 (0):

0이 입력되면, 현재 힙에서 가장 큰 값을 출력하고 제거
현재 힙이 비어 있으므로, -1을 출력 !!!

*/