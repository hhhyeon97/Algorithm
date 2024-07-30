// https://www.acmicpc.net/problem/16112
// 5차 전직

// 메모리 - 55024 KB	시간 - 744 ms
	
package baekjoon.test2;

import java.io.*;
import java.util.*;

public class P16112 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄에서 퀘스트 수와 최대 활성화 가능한 아케인스톤 수 읽기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 퀘스트의 수
        int stone = Integer.parseInt(st.nextToken()); // 최대 활성화 가능한 아케인스톤 수

        // 두 번째 줄에서 경험치 배열 읽기
        long[] exp = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            exp[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        // 경험치 배열을 내림차순으로 정렬
        Arrays.sort(exp);

        long maxExperience = 0; // 총 경험치
        // 현재 활성화 가능한 아케인스톤 수
        int activeStones = 1;

        for (int i = 1; i < n; i++) {
            if (activeStones < stone) {
                maxExperience += exp[i] * activeStones;
                activeStones++;
            } else {
                maxExperience += exp[i] * activeStones;
            }
        }
        System.out.println(maxExperience);

    }
}
