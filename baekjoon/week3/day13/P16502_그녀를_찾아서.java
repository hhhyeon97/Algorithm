// https://www.acmicpc.net/problem/16502

// 14424KB	132ms

package baekjoon.week3.day13;


/*

1. 입력 읽기:

쇼핑 시간과 간선의 수를 입력 받기

간선 정보를 읽어서 그래프를 표현할 데이터 구조(예: 2차원 배열) 준비

2. 확률 전이 행렬 만들기:

각 매장 간의 이동 확률을 행렬로 저장하기 -> ex ) A에서 B로의 확률이 1.0이라면 transition[0][1] = 1.0으로 설정하기

3. 초기 확률 설정:

모든 매장에서 시작할 확률을 같은 값으로 설정하기 -> ex ) initialProb = 1.0 / 4 (매장이 4개이므로)

4. 행렬 제곱을 통한 시간 시뮬레이션:

시간에 맞춰 확률 행렬을 반복적으로 곱해서 그녀의 위치 확률을 업데이트 한다.

5. 결과 출력:

계산된 확률을 퍼센트 단위로 출력하자
*/

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