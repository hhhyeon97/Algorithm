// https://www.acmicpc.net/problem/17608
// 막대기

// 메모리 :  22484 KB	시간 : 244 ms

package baekjoon.week2.day7;

import java.io.*;

public class Test1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 막대기의 개수 (2 <= N <= 100,000)
    int N = Integer.parseInt(br.readLine());

    // 막대기 높이 담을 배열
    int[] h = new int[N];

    // 각 막대기의 높이
    for (int i = 0; i < N; i++) {
      h[i] = Integer.parseInt(br.readLine());
    }
    int count = 1; // 오른쪽에서 보이는 갯수
    int maxHeight = h[h.length - 1]; // 가장 높은 막대기의 높이

    // 오른쪽 부터 비교하기 - >
    // 높이가 가장 높은 막대기 기준으로 비교를 한다.
    // 보이는 막대기 카운트한다.
    // 높이가 오른쪽 막대기보다 높은 막대기가 나오면 변경해준다.
    for (int i = h.length - 2; i >= 0; i--) {
      if (h[i] > maxHeight) {
        count++;
        maxHeight = h[i];
      }
    }

    System.out.println(count);

  }
}