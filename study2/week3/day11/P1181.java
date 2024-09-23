// https://www.acmicpc.net/problem/1181
// 단어 정렬

// 26096KB	336ms

package study2.week3.day11;

import java.io.*;
import java.util.*;
public class P1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어의 개수 입력 받기
        int size = Integer.parseInt(br.readLine().trim());

        // 단어를 저장할 배열 생성
        String[] arr = new String[size];

        // 배열에 단어 입력 받기
        for (int i = 0; i < size; i++) {
            arr[i] = br.readLine().trim();
        }

        // 배열 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이 비교
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                } else {
                    // 길이가 같으면 사전순 비교
                    return s1.compareTo(s2);
                }
            }
        });

        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 중복 제거 및 결과 추가
        for (int i = 0; i < size; i++) {
            // 현재 문자열이 다음 문자열과 다를 때만 추가
            if (i == size - 1 || !arr[i].equals(arr[i + 1])) {
                sb.append(arr[i]).append("\n");
            }
        }

        // 결과 출력
        System.out.print(sb.toString());

    }
}