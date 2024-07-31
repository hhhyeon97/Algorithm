// https://www.acmicpc.net/problem/9375
// 패션왕 신해빈

// 메모리 : 14572  KB  시간 : 148  ms

package baekjoon.week2.day9;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Test4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 의상의 수
            int n = Integer.parseInt(br.readLine());

            // 의상의 종류별로 그룹화
            Map<String, Integer> clothingMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String clothingType = input[1];

                // 각 종류의 의상 개수를 세기
                clothingMap.put(clothingType, clothingMap.getOrDefault(clothingType, 0) + 1);
            }

            // 조합의 경우의 수 계산
            int combinations = 1;
            for (int count : clothingMap.values()) {
                // 각 종류에서 의상 선택 방법 수 
                // (의상 개수 + 1, 선택하지 않는 경우 포함)
                combinations *= (count + 1);
            }

            // 알몸인 경우를 제외
            combinations -= 1;

            // 결과 출력
            bw.write(combinations + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

/*
입력 처리:

BufferedReader로 입력을 읽고, BufferedWriter로 출력을 처리

의상 그룹화:

각 의상의 종류별로 HashMap에 저장
의상 종류를 키로 하고, 그 종류의 의상 개수를 값으로 저장

★ 조합 계산:

각 의상 종류에서 선택할 수 있는 방법은 count + 1 (0부터 count까지의 선택 경우)

==============
상의 [셔츠, 반팔] 하의 [데님]

경우의 수 - > 2x1 = 2

-> 안 선택할 경우 ! 
[셔츠, 반팔, null] [데님, null]

경우의 수 - > 3x2 = 6 

둘 다 안 선택할 경우 ( 알몸이 되면 안 돼 ....)를 제외해주려면
1 빼기 ! 

그럼 최종 경우의 수 5 !!!!!!!

==============

모든 의상 종류의 선택 방법 수를 곱하여 전체 조합의 수를 구한다.
알몸인 경우를 제외하기 위해 결과에서 1을 뺀다.

출력 처리:

각 테스트 케이스의 결과를 출력

*/