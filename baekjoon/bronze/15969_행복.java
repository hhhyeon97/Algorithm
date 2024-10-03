// https://www.acmicpc.net/problem/15969
// 20176KB	224ms

import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int student = scan.nextInt();
        int[] arr = new int[student];
        
        for(int i=0; i<student; i++){
            arr[i] = scan.nextInt();
        }
        int max = Integer.MIN_VALUE;  // 최대값을 찾기 위한 매우 작은 값
        int min = Integer.MAX_VALUE;  // 최소값을 찾기 위한 매우 큰 값
        
         for (int score : arr) {
            if (score < min) min = score;
            if (score > max) max = score;
        }
        System.out.println(max-min);
    }
}