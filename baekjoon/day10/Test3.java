// https://www.acmicpc.net/problem/16466
// 콘서트 

// 메모리 :  177448 KB	시간 : 608 ms

package baekjoon.day10;

import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 티켓 개수 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 티켓 번호 입력 받기
        String[] input = br.readLine().split(" ");

        // 티켓 번호를 저장할 해시 집합 초기화
        Set<Integer> ticketNumbers = new HashSet<>();
        for (String s : input) {
            ticketNumbers.add(Integer.parseInt(s));
        }

        // 가장 작은 양의 정수 번호 찾기
        // HashSet.contains 메서드는 평균적으로 O(1) 시간 복잡도를 가진다.
        int smallestMissing = 1;
        while (ticketNumbers.contains(smallestMissing)) {
            smallestMissing++;
        }

        // 결과 출력
        System.out.println(smallestMissing);

        br.close();
    }
}
