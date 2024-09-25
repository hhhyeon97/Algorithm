// https://www.acmicpc.net/problem/15792
// 15916KB	124ms

package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 15792_AB_2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    sb.append(A / B + "."); // 정수 부분
    A = 10 * (A % B); // 소수 부분을 계산하기 위해 나머지에 10 곱하기

    int T = 1500; // 계산할 자리수, 이 값을 조절할 수 있음
    while (T-- > 0) {
      sb.append(A / B); // 소수점 아래 자리 계산
      A = 10 * (A % B); // 다음 자리 계산을 위해 나머지에 10 곱하기
      if (A == 0)
        break; // 만약 나머지가 0이면 반복 종료
    }

    System.out.println(sb.toString());
  }

}