// https://www.acmicpc.net/problem/11478
// 서로 다른 부분 문자열의 개수

// 메모리 :  230116 KB	시간 : 820 ms

package baekjoon.day9;

import java.io.*;
import java.util.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 문자열 S
        String S = br.readLine();
        int n = S.length();

        br.close();

        // 해시셋을 사용하여 서로 다른 부분 문자열을 저장
        Set<String> result = new HashSet<>();

        // 모든 가능한 부분 문자열을 생성하여 해시셋에 추가
        for (int start = 0; start < n; start++) {
            StringBuilder sb = new StringBuilder();
            for (int end = start; end < n; end++) {
                sb.append(S.charAt(end));
                result.add(sb.toString());
            }
        }

        // 서로 다른 부분 문자열의 개수 출력
        bw.write(String.valueOf(result.size()));
        bw.flush();
        bw.close();
    }
}

