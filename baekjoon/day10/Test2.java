// https://www.acmicpc.net/problem/11557
// Yangjojang of The Year

// 메모리 :  13924 KB	시간 : 116 ms

package baekjoon.day10;


import java.io.*;
import java.util.StringTokenizer;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        // 테스트 케이스의 숫자 입력 받기
        int T = Integer.parseInt(tokenizer.nextToken());

        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            // 학교의 수 입력 받기
            int N = Integer.parseInt(br.readLine());

            String maxSchool = "";
            int maxAlcohol = -1;

            // 각 학교의 이름과 술 소비량 입력 받기
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                tokenizer = new StringTokenizer(line);
                String schoolName = tokenizer.nextToken();
                int alcohol = Integer.parseInt(tokenizer.nextToken());

                // 현재 학교의 소비량이 가장 많으면 업데이트
                if (alcohol > maxAlcohol) {
                    maxAlcohol = alcohol;
                    maxSchool = schoolName;
                }
            }

            // 술짱 학교 출력
            System.out.println(maxSchool);
        }

        br.close();
    }
}