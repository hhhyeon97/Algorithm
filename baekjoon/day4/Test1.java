// https://www.acmicpc.net/problem/2675
// 문자열 반복 

// 메모리 :  17700 KB	시간 : 208 ms

package baekjoon.day4;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 개수 입력 받기
        int T = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        // 각 테스트 케이스 처리
        for (int i = 0; i < T; i++) {
            // 반복 횟수 R과 문자열 S 입력 받기
            int R = sc.nextInt();
            String S = sc.next();

            // 새로운 문자열 P 생성
            StringBuilder P = new StringBuilder();
            for (char c : S.toCharArray()) {
                for (int j = 0; j < R; j++) {
                    P.append(c);
                }
            }

            // 결과 출력
            System.out.println(P.toString());
        }

        sc.close();
    }
}