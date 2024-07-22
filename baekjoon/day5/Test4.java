// https://www.acmicpc.net/problem/10816

// 숫자 카드 2

// 메모리 :  174240 KB 시간 : 1116 ms


/*
상근이가 가지고 있는 숫자 카드의 개수를 세어야 하는 문제

주어진 숫자 카드 목록에서 특정 숫자가 몇 개 있는지 계산하고 출력하는 것
문제를 효율적으로 해결하기 위해 HashMap을 사용할 수 있다.

HashMap은 평균적으로 O(1)의 시간 복잡도로 삽입과 검색이 가능하므로, 
대량의 데이터를 처리하는 데 적합
*/


package baekjoon.day5;


import java.io.*;
import java.util.*;

public class Test4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 상근이가 가지고 있는 숫자 카드의 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // 상근이가 가지고 있는 숫자 카드
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> cardCount = new HashMap<>();
        
        // 카드 숫자와 그 개수를 HashMap에 저장
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        // 검사해야 하는 숫자 카드의 개수 M
        int M = Integer.parseInt(br.readLine());
        
        // 검사해야 하는 숫자 카드
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 각 숫자가 몇 개 있는지 조회
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            sb.append(cardCount.getOrDefault(query, 0)).append(" ");
        }
        
        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}

/*
입력 읽기:

BufferedReader와 StringTokenizer를 사용하여 입력 읽기

카드 개수 세기:

HashMap (cardCount)을 사용하여 상근이가 가진 카드 숫자와 그 개수를 저장
cardCount.getOrDefault(card, 0) + 1을 사용하여 카드가 이미 존재하는지 확인하고, 존재하면 개수를 증가

숫자 카드 조회:

주어진 M개의 숫자 카드에 대해 cardCount에서 해당 숫자의 개수를 조회
getOrDefault(query, 0)을 사용하여 카드가 없으면 0을 반환

결과 출력:

StringBuilder를 사용하여 결과를 효율적으로 구성하고, 최종 결과를 출력
*/