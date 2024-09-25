// https://www.acmicpc.net/problem/4344
// 15708KB	140ms

package baekjoon.bronze;


import java.io.*;

public class 4344_평균은_넘겠지 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int C = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

    for (int i = 0; i < C; i++) {
      String[] input = br.readLine().split(" "); // 학생 수와 점수를 입력받음
      int N = Integer.parseInt(input[0]); // 첫 번째 값은 학생 수
      int sum = 0;

      // 점수 합계 계산
      for (int j = 1; j <= N; j++) {
        sum += Integer.parseInt(input[j]);
      }

      double average = sum / (double) N; // 평균 계산

      // 평균을 넘는 학생 수 계산
      int count = 0;
      for (int j = 1; j <= N; j++) {
        if (Integer.parseInt(input[j]) > average) {
          count++;
        }
      }
      // 비율 계산 및 출력 (소수점 셋째 자리까지 반올림)
      double percentage = (count / (double) N) * 100;
      System.out.printf("%.3f%%\n", percentage);
    }

    br.close();
  }

}