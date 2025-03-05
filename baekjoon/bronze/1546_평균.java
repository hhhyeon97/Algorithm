
// https://www.acmicpc.net/problem/1546

// 19344KB	212ms

package baekjoon.bronze;

import java.util.*;

public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        double sum = 0;
        double max = 0;
        
        for(int i=0; i<n; i++){
            
            int score = sc.nextInt();

            if(score>max){
                max = score;
            }

            sum+=score;
        }

        System.out.println((sum/max)*100.0/n);
        
    }
}
