
// https://www.acmicpc.net/problem/10816
// 숫자 카드 2

// 174264KB	 964ms

/*
 * 시간 복잡도:
 
O(N): 상근이가 가진 숫자 카드들을 모두 처리하는 데 걸리는 시간.
O(1): HashMap에서 카드의 개수를 조회하는 데 걸리는 시간.
O(M): 확인해야 할 숫자들 각각을 처리하는 데 걸리는 시간.
ㄴ> 전체 시간 복잡도는 O(N + M) !!
N개의 숫자 카드를 읽고, M개의 숫자를 확인하는 작업을 모두 합친 것
*/

import java.io.*;
import java.util.*;

public class 10816번 {
    public static void main(String[] args) throws IOException {
    

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 상근이가 가진 숫자 카드의 개수 N
    int N = Integer.parseInt(br.readLine());
    
    // 상근이의 카드 빈도를 저장할 HashMap
    HashMap<Integer, Integer> cardMap = new HashMap<>();
    
    // 상근이의 카드 배열 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
        int num = Integer.parseInt(st.nextToken());
        // cardMap에 숫자의 빈도를 저장 (없으면 0, 있으면 +1)
        cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
    }
    
    // 확인해야 할 숫자의 개수 M
    int M = Integer.parseInt(br.readLine());
    
    // 확인해야 할 숫자 배열 입력
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
        int query = Integer.parseInt(st.nextToken());
        // cardMap에서 해당 숫자의 빈도를 찾음 (없으면 0)
        sb.append(cardMap.getOrDefault(query, 0)).append(" ");
    }
    
    // 결과 출력
    bw.write(sb.toString().trim());
    bw.flush();
    bw.close();
    br.close();
    }
}
