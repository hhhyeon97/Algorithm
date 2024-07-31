// https://www.acmicpc.net/problem/1026
// 보물

// 14316KB	112ms

package baekjoon.week3.day11;

import java.io.*;
import java.util.*;

public class P1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
         * - 입력
         * 첫째 줄 - > 배열 길이 N 입력 받기
         * 둘째 줄 - > A 배열에 넣을 N개의 수 입력 받기
         * 셋째 줄 - > B 배열에 넣을 N개의 수 입력 받기
         * N은 50보다 작거나 같은 자연수 / A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수
         * 
         * - 함수 S
         * S = A[0] × B[0] + ... + A[N-1] × B[N-1]
         * 
         * ※ S의 값을 가장 작게 만들기 위해 A의 수를 재배열 하기 -> B에 있는 수는 재배열 x
         * - > 근데 왜 ?! 둘 다 재배열 했는데도 정답 처리가 됐지 ?! 
         * 
         * - 출력
         * 첫째 줄에 S의 최솟값 출력하기
         */
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        // 내림차순 정렬을 하려면 int가 아닌 Integer로 선언
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        // A 올림, B 내림
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += (A[i] * B[i]);
            /*
             * 예제 1
             * 5
             * 1 1 1 6 0
             * 2 7 8 3 1
             * 2번째줄 A를 오름차순 정렬했음
             * -> 0 1 1 1 6
             * 3번째줄 B를 내림차순 정렬했음
             * -> 8 7 3 2 1
             * 
             * 0x8 + 1x7 + 1x3 + 1x2 + 6x1 = 0 + 7 + 3 + 2 + 6 = 18
             */
        }
        System.out.println(sum);

    }
}

/* 34-5번줄 -> 각 줄의 숫자들을 별도로 읽어야 하기 때문에 각각 다른 StringTokenizer를 사용한 것 !
StringTokenizer는 한 번에 하나의 문자열만 처리할 수 있기 때문에
두 개의 문자열을 읽으려면 각각 별도의 StringTokenizer 인스턴스가 필요하다. 
하나의 StringTokenizer를 재사용하려면 
이전에 처리한 문자열이 끝나야 하기 때문에, 두 개의 입력을 동시에 처리할 수는 없다 !
*/