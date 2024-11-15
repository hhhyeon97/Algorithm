
// https://www.acmicpc.net/problem/2750
// 22404KB	276ms

package baekjoon.bronze;

import java.util.*;

public class 2750_수_정렬하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        sc.close();
    }    
}
