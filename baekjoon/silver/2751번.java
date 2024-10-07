
// https://www.acmicpc.net/problem/2751
// 121096KB	1264ms

// Arrays.sort()로 접근하면 시간 초과됨

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class 2751번 {
    public static void main(String[] args) throws IOException {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 수의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> numbers = new ArrayList<>(N);

        // 두 번째 줄부터 N개의 수 입력
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        // 오름차순 정렬
        Collections.sort(numbers);

        // 출력 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append("\n");
        }

        // 결과 한 번에 출력
        System.out.print(sb);
        br.close();
    }
}