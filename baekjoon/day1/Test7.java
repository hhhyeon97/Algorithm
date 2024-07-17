// https://www.acmicpc.net/problem/4344

// 입력된 점수들을 바탕으로 평균을 넘는 학생의 비율 계산 후
// 원하는 형식으로 출력하는 문제 

// 메모리 : 33028 KB	시간 : 436 ms

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();  // 테스트 케이스의 수

        for (int i = 0; i < C; i++) {
            int N = sc.nextInt();  // 학생의 수
            int[] scores = new int[N];
            int sum = 0;

            // 점수 입력 및 합계 계산
            for (int j = 0; j < N; j++) {
                scores[j] = sc.nextInt();
                sum += scores[j];
            }

            double average = sum / (double) N;  // 평균 계산

            // 평균을 넘는 학생 수 계산
            int countAboveAverage = 0;
            for (int score : scores) {
                if (score > average) {
                    countAboveAverage++;
                }
            }

            // 비율 계산 및 출력
            double percentage = (countAboveAverage / (double) N) * 100;
            System.out.printf("%.3f%%\n", percentage);
        }

        sc.close();
    }
}