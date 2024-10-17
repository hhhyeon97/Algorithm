
// https://www.acmicpc.net/problem/10871
// 15356KB	132ms

/* 처음에 그냥 버퍼리더만 써서 풀면 틀림 !
   N과 X는 첫 번째 줄에서 공백으로 구분되어 입력되기 때문에
   StringTokenizer를 사용해 N과 X를 읽음.
   수열 A는 한 줄에 공백으로 구분된 여러 숫자가 입력되므로, 
   역시 StringTokenizer를 사용하여 처리.
   StringBuilder를 사용해 효율적으로 문자열을 누적하고 마지막에 출력
 */

package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 10871_X보다_작은_수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 N과 X를 읽어 오기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 두 번째 줄에서 수열 A를 읽어 오기
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num < X){
                sb.append(num).append(" ");
            }
        }
        // 출력
        System.out.println(sb.toString().trim());
        br.close();
    }
}
