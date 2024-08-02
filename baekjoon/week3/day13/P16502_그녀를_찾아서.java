// https://www.acmicpc.net/problem/16502

// 14424KB	132ms

package baekjoon.week3.day13;


import java.io.*;
import java.util.*;

public class P16502_그녀를_찾아서 {
    static final int N = 4; // 매장 수
    static final String[] STORES = { "A", "B", "C", "D" };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine()); // 쇼핑 시간
        int M = Integer.parseInt(br.readLine()); // 간선 수

        // 전이 행렬 초기화
        double[][] transition = new double[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(transition[i], 0);
        }

        // 간선 정보 읽기
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String from = input[0];
            String to = input[1];
            double prob = Double.parseDouble(input[2]);
            int fromIndex = indexOf(from);
            int toIndex = indexOf(to);
            transition[fromIndex][toIndex] = prob;
        }

        // 초기 확률 설정
        double[] prob = new double[N];
        Arrays.fill(prob, 1.0 / N);

        // 시간만큼 반복하여 확률 계산
        for (int t = 0; t < time; t++) {
            double[] newProb = new double[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    newProb[j] += prob[i] * transition[i][j];
                }
            }
            prob = newProb;
        }

        // 결과 출력
        for (double p : prob) {
            System.out.printf("%.2f\n", p * 100);
        }
    }

    // 매장 이름을 인덱스로 변환
    static int indexOf(String store) {
        for (int i = 0; i < N; i++) {
            if (STORES[i].equals(store)) {
                return i;
            }
        }
        return -1;
    }
}