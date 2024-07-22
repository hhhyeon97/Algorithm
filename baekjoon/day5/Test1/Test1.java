// https://www.acmicpc.net/problem/24265
// 알고리즘 수업 - 알고리즘의 수행 시간 4

// 메모리 :  14224 KB 시간 : 128 ms

// 계산된 수행 횟수와 알고리즘의 최고차항의 차수 출력하기

package baekjoon.day5.Test1;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        // 코드1의 수행 횟수를 계산
        // (n-1) * n / 2를 계산하고, long 타입으로 변환
        // -> int 범위 초과할 경우 방지
        long count = (long) (n - 1) * n / 2;

        // 계산된 수행 횟수를 출력
        System.out.println(count);

        // 수행 시간이 n^2에 비례하기 때문에 최고차항의 차수를 2로 출력
        System.out.println(2);
    }
}

/*
for i <- 1 to n-1

이 루프는 i가 1부터 n-1까지 반복
for j <- i + 1 to n

이 루프는 i가 특정 값일 때, j가 i+1부터 n까지 반복

예를 들어, n=4인 경우

i=1일 때: j는 2, 3, 4 (3회)
i=2일 때: j는 3, 4 (2회)
i=3일 때: j는 4 (1회)
--> 총 수행 횟수는 3 + 2 + 1 = 6회


이를 일반화하면:

i=1일 때: n-1회
i=2일 때: n-2회
...
i=n-1일 때: 1회


이 합을 구하면:

(n-1) + (n-2) + ... + 1

-- > 등차수열의 합 공식으로 다듬으면

(n-1) * n / 2


*/