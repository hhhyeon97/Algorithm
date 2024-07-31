// https://www.acmicpc.net/problem/10815

// 숫자 카드

// 메모리 :  136604 KB 시간 : 960 ms


/*
주어진 숫자 카드 목록에서 특정 숫자가 존재하는지 확인하는 문제
주어진 범위가 크기 때문에 효율적으로 풀어야 한다.

효율적으로 존재 여부를 확인하기 위해 해시셋(HashSet)이나 정렬 후 이진 탐색(Binary Search)을 사용할 수 있다.

HashSet 선택 !


문제 풀이 흐름 

1.상근이가 가진 숫자 카드를 HashSet에 저장
2. 주어진 숫자가 HashSet에 있는지 확인
3. 결과 출력

HashSet을 사용하는 이유

HashSet은 평균적으로 O(1)의 시간 복잡도로 요소의 삽입과 검색이 가능합니다.
- > 큰 데이터 범위에서도 효율적으로 동작한다.
*/


package baekjoon.week1.day5;

import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 상근이가 가지고 있는 숫자 카드의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄: 상근이가 가지고 있는 숫자 카드에 적혀있는 정수들
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> cardSet = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            cardSet.add(Integer.parseInt(st.nextToken()));
        }

        // 세 번째 줄: 검사해야 하는 숫자 카드의 개수 M
        int M = Integer.parseInt(br.readLine());

        // 네 번째 줄: 검사해야 하는 M개의 정수
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (cardSet.contains(number)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}

/*
입력 읽기:

BufferedReader를 사용하여 입력을 빠르게 읽는다.
StringTokenizer를 사용하여 공백으로 구분된 숫자들을 읽는다.

두 번째 줄의 숫자 카드들을 HashSet에 저장

검사해야 하는 숫자 확인:

네 번째 줄의 숫자들을 하나씩 읽고, HashSet에 존재하는지 확인
존재하면 1, 존재하지 않으면 0을 결과 문자열에 추가

결과 출력 -> StringBuilder에 저장된 결과를 출력한다.

HashSet을 사용하여 검색 시간을 줄였고, StringBuilder를 사용하여 출력 성능을 최적화했다.
*/