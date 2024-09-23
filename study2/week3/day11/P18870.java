// https://www.acmicpc.net/problem/18870
// 좌표 압축

// https://kkungchan.tistory.com/302 참고


// 276924KB	1808ms

package study2.week3.day11;

import java.io.*;
import java.util.*;

public class P18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 단어의 개수 입력 받기
        int N = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[N]; // 원본 배열
        int[] arrSort = new int[N]; // 정렬된 배열
        Map<Integer, Integer> rankMap = new HashMap<>(); // 압축할 map

        // N만큼 배열 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // arr 배열 복제
        arrSort = arr.clone();

        // 배열 정렬
        Arrays.sort(arrSort);

        int rank = 0;

        // 배열의 압축값을 map에 저장
        for (int value : arrSort) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }

        // 원본 배열의 순서대로 해당 압축 배열을 출력
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(rankMap.get(value)).append(' ');
        }
        bw.write(sb.toString().trim());

        bw.flush();
        br.close();
        bw.close();

    }
}
