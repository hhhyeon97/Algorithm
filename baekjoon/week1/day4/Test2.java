// https://www.acmicpc.net/problem/1152
// 단어의 개수 

package baekjoon.week1.day4;

// 메모리 :  27104 KB	시간 : 372 ms

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력 받기
        String input = br.readLine().trim();

        // 공백을 기준으로 문자열 분리
        if (input.isEmpty()) {
            // 입력된 문자열이 공백만 있는 경우
            System.out.println(0);
        } else {
            String[] words = input.split("\\s+");
            // 단어 개수 출력
            System.out.println(words.length);
        }

        br.close();
    }
}