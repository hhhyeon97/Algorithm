// https://www.acmicpc.net/problem/23881
// 알고리즘 수업 - 선택 정렬 1

// 문제 - > 선택 정렬 과정에서 K번째 교환되는 수 찾기

// 32028KB	624ms

package baekjoon.week2.study;

import java.util.Scanner;


public class SortTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 배열의 크기와 교환 횟수 입력받기
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // 배열 원소들을 입력받기
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // K번째 교환을 찾기 위한 변수
        int swapCount = 0;
        int[] swapResult = new int[2];

        // 선택 정렬 알고리즘
        /*
         * last를 배열의 끝에서부터 시작하여 1까지 감소시켜가며 반복
         * 각 반복에서 A[0..last] 부분에서 가장 큰 값을 찾고, last 위치와 교환하기 !
         */
        for (int last = N - 1; last > 0; last--) {
            int maxIndex = 0;
            // A[0..last]에서 가장 큰 값을 찾기
            for (int i = 1; i <= last; i++) {
                if (A[i] > A[maxIndex]) {
                    maxIndex = i;
                }
            }

            /*
             * 교환 횟수 확인
             * 
             * 교환을 수행할 때마다 swapCount를 증가시키기
             * swapCount가 K와 같으면 현재 교환된 두 수를 저장
             */
            // 가장 큰 값이 마지막 위치에 있지 않으면 교환
            if (last != maxIndex) {
                // 교환
                int temp = A[last];
                A[last] = A[maxIndex];
                A[maxIndex] = temp;

                // 교환 횟수 증가
                swapCount++;

                // K번째 교환을 찾기
                if (swapCount == K) {
                    swapResult[0] = Math.min(A[last], A[maxIndex]);
                    swapResult[1] = Math.max(A[last], A[maxIndex]);
                    break;
                }
            }
        }
        /*
         * 교환 횟수가 K보다 크거나 같으면 해당 교환된 수를 출력
         * 그렇지 않으면 -1을 출력
         */
        // K번째 교환 결과 출력
        if (swapCount >= K) {
            System.out.println(swapResult[0] + " " + swapResult[1]);
        } else {
            System.out.println(-1);
        }

        scanner.close();
    }
}
