
// https://www.acmicpc.net/problem/10818

// 318868KB	1536ms -> 버퍼로 바꿔보자

package baekjoon.bronze;
/*
import java.util.*;

public class 10818_최소_최대 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        
        // 최솟값과 최댓값을 배열의 첫 번째 값으로 초기화
        int min = arr[0];
        int max = arr[0];

        // 배열을 순회하면서 최솟값과 최댓값 갱신
        for (int i = 1; i < N; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
        if (arr[i] > max) {
            max = arr[i];
        }
        }
        // 결과 출력
        System.out.println(min + " " + max);
    
        sc.close();
    }
}
 */

// 88688KB	460ms
 
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        // 둘째 줄에서 정수들 읽어오기
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 번째 값으로 최솟값과 최댓값 초기화
        int min = 1000000;  // 문제에서 주어진 최댓값
        int max = -1000000; // 문제에서 주어진 최솟값
        
        // N개의 정수에 대해 반복하면서 최솟값과 최댓값을 구함
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.println(min + " " + max);
        br.close();
    }
}